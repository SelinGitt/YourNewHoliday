/**
 * 
 */
package service.produit.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.produit.dao.IProduitDao;
import presentation.panier.dto.PanierDto;
import presentation.produit.controller.TypeFiltre;
import presentation.produit.controller.TypeTriAlphanumerique;
import presentation.produit.dto.BeanQuantite;
import presentation.produit.dto.ProduitDto;
import service.panier.IPanierService;
import service.produit.IProduitService;
import service.produit.ProduitMapper;
import service.produit.util.ProduitEditerResponse;
import service.utilisateur.util.UtilisateurRoleEnum;

/**
 * Classe repr�sentant l'interface m�tier {@link IProduitService}
 *
 * @author Administrateur
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProduitService implements IProduitService {

    // insertion du logger pour ajouter le logg des requ�tes sql dans le fichier
    private final Logger   logger = LoggerFactory.getLogger(ProduitService.class);

    @Autowired
    private IProduitDao    produitDao;

    @Autowired
    private IPanierService panierService;

    @Override
    public List<ProduitDto> listerProduitsEnVente() {
        return ProduitMapper.mapToListDto(produitDao.findAllProduitsEnVente());
    }

    @Override
    public ProduitDto trouverProduitEnVente(final Integer idProduit) {
        logger.debug("Produit Service / m�thode trouverProduitEnVente, idProduit : {}", idProduit);
        return ProduitMapper.mapToDto(produitDao.findProduitEnVente(idProduit));
    }

    @Override
    public List<ProduitDto> listerAllProduit() {
        return ProduitMapper.mapToListDto(produitDao.findAllProduitsTriAlpha());
    }

    @Override
    public List<ProduitDto> rechercherProduitsEnVente(final String pSearchTerm) {
        logger.debug("Produit Service / m�thode rechercherProduitsEnVente, pSearchTerm : {}", pSearchTerm);
        return ProduitMapper.mapToListDto(produitDao.rechercherProduitsEnVente(pSearchTerm));
    }

    @Override
    public List<ProduitDto> findFilter(final String searchTerm, final TypeTriAlphanumerique tri) {
        final var triString = String.valueOf(tri);
        logger.debug("Produit Service findFilter, searchTerm : {} ; tri : {}", searchTerm, triString);
        if (searchTerm.isBlank()) {
            if (tri == null) {
                return listerProduitsEnVente();
            }
            return trierListe(tri);
        }

        if (tri == null) {
            if (searchTerm.isBlank()) {
                return listerAllProduit();
            }
            return rechercherProduitsEnVente(searchTerm);
        }
        return listerFiltreTri(tri, searchTerm);
    }

    private List<ProduitDto> listerFiltreTri(final TypeTriAlphanumerique typeFiltre, final String searchTerm) {
        logger.debug("Produit Service / m�thode listerFiltreTri, typeFiltre : {} ; searchTerm : {}", typeFiltre, searchTerm);
        return ProduitMapper.mapToListDto(produitDao.trierFiltreListe(typeFiltre, searchTerm));
    }

    private List<ProduitDto> trierListe(final TypeTriAlphanumerique typeFiltre) {
        logger.debug("Produit Service / m�thode trierListe, typeFiltre : {}", typeFiltre);
        return ProduitMapper.mapToListDto(produitDao.trierListe(typeFiltre));
    }

    @Override
    public ProduitEditerResponse editerProduit(final ProduitDto produitDto) {
        final var produitFound = trouverProduitById(Integer.valueOf(produitDto.getIdProduitOriginal()));

        final var builder = new ProduitEditerResponse.ProduitEditerResponseBuilder();

        // Check si le produit existe
        if (produitFound == null) {
            this.logger.error("Produit Service / editerProduit - Produit introuvable avec id {}", produitDto.getIdProduitOriginal());
            return builder.withError("deleted").build();
        }

        // Check si le produit est a jour
        if (!produitFound.getVersion().equals(produitDto.getVersion())) {
            this.logger.error("Produit Service / editerProduit - Le produit edite n'est pas a jour {}", produitDto.getIdProduitOriginal());
            return builder.withError("updated").build();
        }

        // Check si la reference est libre
        final var produitRef = this.trouverParReference(produitDto.getReference());
        if ((produitRef != null) && (!produitRef.getIdProduitOriginal().equals(produitDto.getIdProduitOriginal()))) {
            this.logger.error("Produit Service / editerProduit - Reference deja prise {}", produitDto.getReference());
            return builder.withError("reference").build();
        }

        this.logger.debug("Produit Service / editerProduit - m�thode trouverById avec id : {} -> ref produit trouv� : {} ",
                produitDto.getIdProduitOriginal(), produitFound.getReference());
        // Incrementation de la version du produit si les DTO sont diff�rents, sinon la version actuelle du produitDto est retorun�e
        if (produitFound.toString().hashCode() != (produitDto.toString().hashCode())) {
            final var produitDoWithChanges = ProduitMapper.mapToDo(produitDto);
            this.logger.debug("Produit Service / editerProduit - Les produits sont diff�rents");
            produitDoWithChanges.setVersion(produitDoWithChanges.getVersion() + 1);
            return builder.withPdt(ProduitMapper.mapToDto(produitDao.update(produitDoWithChanges))).build();
        }
        this.logger.debug("Produit Service / editerProduit - Les produits sont identiques");
        return builder.withPdt(produitFound).build();
    }

    @Override
    public ProduitDto trouverParReference(final String reference) {
        final var produitDo = produitDao.findByReference(reference);
        this.logger.debug("Produit Service {} trouverParReference", reference);
        return produitDo == null ? null : ProduitMapper.mapToDto(produitDo);
    }

    @Override
    public List<ProduitDto> rechercherAllProduits(final String pSearchTerm) {
        logger.debug("Produit Service / m�thode rechercherAllProduits, pSearchTerm : {}", pSearchTerm);
        if (pSearchTerm.isEmpty()) {
            return ProduitMapper.mapToListDto(produitDao.findAll());
        }
        return ProduitMapper.mapToListDto(produitDao.rechercherAllProduits(pSearchTerm));
    }

    @Override
    public ProduitDto creerProduit(final ProduitDto produitDto) {

        final var produitDtoTrouve = this.trouverParReference(produitDto.getReference());
        if (produitDtoTrouve == null) {
            final var produitDo = ProduitMapper.mapToDo(produitDto);
            this.logger.debug("La r�f�rence : {} a �t� utilis� dans la m�thode creerProduit", produitDto.getReference());
            return ProduitMapper.mapToDto(produitDao.create(produitDo));
        }
        this.logger.info(" La r�f�rence  {} existe d�j� en BdD ", produitDto.getReference());
        return null;
    }

    @Override
    public ProduitDto trouverProduitById(final Integer idProduit) {
        final var produitDo = produitDao.findById(idProduit);
        this.logger.debug("Produit Service id: {}, methode trouverById", idProduit);
        return produitDo == null ? null : ProduitMapper.mapToDto(produitDo);
    }

    @Override
    public boolean deleteProduit(final Integer id) {
        final var produitDo = produitDao.findById(id);
        if (produitDo == null) {
            this.logger.warn("Le produit d'id  {} n'existe pas en BdD.", id);
            return false;
        }
        produitDao.delete(produitDo);
        this.logger.debug("Le produit d'id  {} a �t� supprim�.", id);
        return true;
    }

    @Override
    public PanierDto updatePanier(final PanierDto panierDto, final BeanQuantite beanQuantite) {
        logger.debug("ProduitService {} updatePanier, quantite: {}, id: {}", PanierDto.class.getSimpleName(), beanQuantite.getQuantite(),
                beanQuantite.getId());
        final var quantite = Integer.valueOf(beanQuantite.getQuantite());
        final var id = Integer.parseInt(beanQuantite.getId());
        return (quantite >= 100 || quantite <= 0) ? null : panierService.updatePanier(panierDto, id, quantite);
    }

    @Override
    public List<ProduitDto> filtrerEnVente(final String searchTerm, final TypeFiltre filtre) {
        if (searchTerm.isBlank()) {
            if (filtre == null) {
                return listerAllProduit();
            }
            return trouverProduitsFiltre(filtre);
        }
        if (filtre == null) {
            return rechercherAllProduits(searchTerm);
        }
        return trouverProduitsFiltreRecherche(searchTerm, filtre);
    }

    private List<ProduitDto> trouverProduitsFiltre(final TypeFiltre filtre) {
        return ProduitMapper.mapToListDto(produitDao.trouverProduitsFiltre(filtre));
    }

    private List<ProduitDto> trouverProduitsFiltreRecherche(final String searchTerm, final TypeFiltre filtre) {
        return ProduitMapper.mapToListDto(produitDao.trouverProduitsRechercheFiltre(searchTerm, filtre));
    }

    @Override
    public ProduitDto consulterProduitWithRole(final UtilisateurRoleEnum role, final Integer idProduit) {
        if (UtilisateurRoleEnum.ADMINISTRATEUR == role) {
            return ProduitMapper.mapToDto(produitDao.findById(idProduit));
        }
        return ProduitMapper.mapToDto(produitDao.findProduitEnVente(idProduit));
    }
}
