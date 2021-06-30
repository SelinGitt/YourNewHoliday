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
        return ProduitMapper.mapToListDto(produitDao.rechercherProduits(pSearchTerm));
    }

    @Override
    public List<ProduitDto> listerAllProduit() {
        return ProduitMapper.mapToListDto(produitDao.findAll());
    }

    @Override
    public ProduitDto editerProduit(final ProduitDto produitDto) {
        final var produitDo = ProduitMapper.mapToDo(produitDto);
        return ProduitMapper.mapToDto(produitDao.update(produitDo));
    }

    @Override
    public ProduitDto trouverParReference(final String reference) {
        final var produitDo = produitDao.findByReference(reference);
        return produitDo == null ? null : ProduitMapper.mapToDto(produitDo);
    }
}
