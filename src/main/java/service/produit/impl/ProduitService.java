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
import presentation.produit.controller.TypeTriAlphanumerique;
import presentation.produit.dto.BeanQuantite;
import presentation.produit.dto.ProduitDto;
import service.panier.IPanierService;
import service.produit.IProduitService;
import service.produit.ProduitMapper;

/**
 * Classe représentant l'interface métier {@link IProduitService}
 *
 * @author Administrateur
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProduitService implements IProduitService {

    // insertion du logger pour ajouter le logg des requêtes sql dans le fichier
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
        logger.debug("Produit Service / méthode trouverProduitEnVente, idProduit : {}", idProduit);
        return ProduitMapper.mapToDto(produitDao.findProduitEnVente(idProduit));
    }

    @Override
    public List<ProduitDto> listerAllProduit() {
        return ProduitMapper.mapToListDto(produitDao.findAll());
    }

    @Override
    public List<ProduitDto> rechercherProduitsEnVente(final String pSearchTerm) {
        logger.debug("Produit Service / méthode rechercherProduitsEnVente, pSearchTerm : {}", pSearchTerm);
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
            return rechercherProduits(searchTerm);
        }
        return listerFiltreTri(tri, searchTerm);
    }

    private List<ProduitDto> listerFiltreTri(final TypeTriAlphanumerique typeFiltre, final String searchTerm) {
        logger.debug("Produit Service / méthode listerFiltreTri, typeFiltre : {} ; searchTerm : {}", typeFiltre, searchTerm);
        return ProduitMapper.mapToListDto(produitDao.trierFiltreListe(typeFiltre, searchTerm));
    }

    private List<ProduitDto> trierListe(final TypeTriAlphanumerique typeFiltre) {
        logger.debug("Produit Service / méthode trierListe, typeFiltre : {}", typeFiltre);
        return ProduitMapper.mapToListDto(produitDao.trierListe(typeFiltre));
    }

    private List<ProduitDto> rechercherProduits(final String pSearchTerm) {
        logger.debug("Produit Service / méthode rechercherProduits, pSearchTerm : {}", pSearchTerm);
        return ProduitMapper.mapToListDto(produitDao.rechercherAllProduits(pSearchTerm));

    }

    @Override
    public ProduitDto editerProduit(final ProduitDto produitDto) {
        final var produitFound = trouverProduitById(Integer.valueOf(produitDto.getIdProduitOriginal()));
        this.logger.debug("Produit Service {} editerProduit, id : {}", produitFound, produitDto.getIdProduitOriginal());
        // On update si le produit existe
        if (produitFound != null) {
            final var produitDo = ProduitMapper.mapToDo(produitDto);
            return ProduitMapper.mapToDto(produitDao.update(produitDo));
        }
        return null;
    }

    @Override
    public ProduitDto trouverParReference(final String reference) {
        final var produitDo = produitDao.findByReference(reference);
        this.logger.debug("Produit Service {} trouverParReference", reference);
        return produitDo == null ? null : ProduitMapper.mapToDto(produitDo);
    }

    @Override
    public List<ProduitDto> rechercherAllProduits(final String pSearchTerm) {
        logger.debug("Produit Service / méthode rechercherAllProduits, pSearchTerm : {}", pSearchTerm);
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
            this.logger.debug("La référence : {} a été utilisé dans la méthode creerProduit", produitDto.getReference());
            return ProduitMapper.mapToDto(produitDao.create(produitDo));
        }
        this.logger.info(" La référence  {} existe déjà en BdD ", produitDto.getReference());
        return null;
    }

    @Override
    public ProduitDto trouverProduitById(final Integer idProduit) {
        final var produitDo = produitDao.findById(idProduit);
        this.logger.debug("Produit Service id: {}, methode trouverById", idProduit);
        return produitDo == null ? null : ProduitMapper.mapToDto(produitDo);
    }

    @Override
    public PanierDto updatePanier(final PanierDto panierDto, final BeanQuantite beanQuantite) {
        logger.debug("ProduitService {} updatePanier, quantite: {}, id: {}", PanierDto.class.getSimpleName(), beanQuantite.getQuantite(),
                beanQuantite.getId());
        final var quantite = Integer.valueOf(beanQuantite.getQuantite());
        final var id = Integer.parseInt(beanQuantite.getId());
        return (quantite >= 100 || quantite <= 0) ? null : panierService.updatePanier(panierDto, id, quantite);
    }
}
