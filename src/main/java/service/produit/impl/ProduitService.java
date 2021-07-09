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
import presentation.produit.dto.BeanQuantite;
import presentation.produit.dto.ProduitDto;
import service.panier.IPanierService;
import service.produit.IProduitService;
import service.produit.ProduitMapper;

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
        return ProduitMapper.mapToDto(produitDao.findProduitEnVente(idProduit));
    }

    @Override
    public List<ProduitDto> rechercherProduitsEnVente(final String pSearchTerm) {
        return ProduitMapper.mapToListDto(produitDao.rechercherProduitsEnVente(pSearchTerm));
    }

    @Override
    public List<ProduitDto> listerAllProduit() {
        return ProduitMapper.mapToListDto(produitDao.findAll());
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
        if (Integer.valueOf(beanQuantite.getQuantite()) >= 100 || Integer.valueOf(beanQuantite.getQuantite()) <= 0) {
            return null;
        }
        return panierService.updatePanier(panierDto, Integer.parseInt(beanQuantite.getId()), Integer.parseInt(beanQuantite.getQuantite()));
    }
}
