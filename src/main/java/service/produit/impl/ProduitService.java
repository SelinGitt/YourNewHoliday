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
import presentation.produit.controller.TypeTri;
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
    public List<ProduitDto> rechercherProduits(final String pSearchTerm) {
        if (!pSearchTerm.isBlank()) {
            return ProduitMapper.mapToListDto(produitDao.rechercherProduits(pSearchTerm));
        }
        return ProduitMapper.mapToListDto(produitDao.findAllProduitsEnVente());
    }

    @Override
    public List<ProduitDto> listerAllProduit() {
        return ProduitMapper.mapToListDto(produitDao.findAll());
    }

    @Override
    public List<ProduitDto> listerFiltreTri(final TypeTri typeFiltre, final String searchTerm) {
        return ProduitMapper.mapToListDto(produitDao.trierFiltreListe(typeFiltre, searchTerm));
    }

    @Override
    public List<ProduitDto> trierListe(final TypeTri typeFiltre) {
        return ProduitMapper.mapToListDto(produitDao.trierListe(typeFiltre));
    }

}
