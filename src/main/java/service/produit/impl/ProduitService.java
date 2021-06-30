/**
 * 
 */
package service.produit.impl;

import java.util.List;

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

    @Autowired
    private IProduitDao produitDao;

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
    public List<ProduitDto> findFilter(final String searchTerm, final String tri) {
        final var typeTri = TypeTriAlphanumerique.getValue(tri);
        if (!searchTerm.isBlank()) {
            if ("0".equals(tri)) {
                return rechercherProduits(searchTerm);
            }
            return listerFiltreTri(typeTri.checkType(), searchTerm);
        }
        if ("0".equals(tri)) {
            return listerProduitsEnVente();
        }
        return trierListe(typeTri.checkType());
    }

    private List<ProduitDto> listerFiltreTri(final TypeTriAlphanumerique typeFiltre, final String searchTerm) {
        return ProduitMapper.mapToListDto(produitDao.trierFiltreListe(typeFiltre, searchTerm));
    }

    private List<ProduitDto> trierListe(final TypeTriAlphanumerique typeFiltre) {
        return ProduitMapper.mapToListDto(produitDao.trierListe(typeFiltre));
    }

    private List<ProduitDto> rechercherProduits(final String pSearchTerm) {
        return ProduitMapper.mapToListDto(produitDao.rechercherProduits(pSearchTerm));

    }
}
