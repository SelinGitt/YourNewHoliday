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
import presentation.produit.controller.TypeTriAlphanumerique;
import presentation.produit.dto.ProduitDto;
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
    private final Logger logger = LoggerFactory.getLogger(ProduitService.class);

    @Autowired
    private IProduitDao  produitDao;

    @Override
    public List<ProduitDto> listerProduitsEnVente() {
        return ProduitMapper.mapToListDto(produitDao.findAllProduitsEnVente());
    }

    @Override
    public ProduitDto trouverProduitEnVente(final Integer idProduit) {
        return ProduitMapper.mapToDto(produitDao.findProduitEnVente(idProduit));
    }

    @Override
    public List<ProduitDto> listerAllProduit() {
        return ProduitMapper.mapToListDto(produitDao.findAll());
    }

    @Override
    public List<ProduitDto> rechercherProduitsEnVente(final String pSearchTerm) {
        return ProduitMapper.mapToListDto(produitDao.rechercherProduitsEnVente(pSearchTerm));
    }

    @Override
    public List<ProduitDto> findFilter(final String searchTerm, final TypeTriAlphanumerique tri) {
        final var triString = String.valueOf(tri);
        logger.debug("{} a été appelé avec {} et {} comme paramètres", ProduitDto.class.getSimpleName(), searchTerm, triString);
        if (!searchTerm.isBlank()) {
            if (tri == null) {
                return rechercherProduits(searchTerm);
            }
            return listerFiltreTri(tri, searchTerm);
        }
        if (tri == null) {
            return listerProduitsEnVente();
        }
        return trierListe(tri);
    }

    private List<ProduitDto> listerFiltreTri(final TypeTriAlphanumerique typeFiltre, final String searchTerm) {
        return ProduitMapper.mapToListDto(produitDao.trierFiltreListe(typeFiltre, searchTerm));
    }

    private List<ProduitDto> trierListe(final TypeTriAlphanumerique typeFiltre) {
        return ProduitMapper.mapToListDto(produitDao.trierListe(typeFiltre));
    }

    private List<ProduitDto> rechercherProduits(final String pSearchTerm) {
        return ProduitMapper.mapToListDto(produitDao.rechercherAllProduits(pSearchTerm));

    }

    @Override
    public List<ProduitDto> rechercherAllProduits(final String pSearchTerm) {
        if (pSearchTerm.isEmpty()) {
            return ProduitMapper.mapToListDto(produitDao.findAll());
        }
        return ProduitMapper.mapToListDto(produitDao.rechercherAllProduits(pSearchTerm));
    }

    @Override
    public ProduitDto creerProduit(final ProduitDto produitDto) {
        final var produitDo = ProduitMapper.mapToDo(produitDto);
        this.logger.debug("Produit Service {} creerProduit", produitDto.getClass().getSimpleName());
        return ProduitMapper.mapToDto(produitDao.create(produitDo));
    }
}
