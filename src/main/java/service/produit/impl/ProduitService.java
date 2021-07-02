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
 * Classe repr�sentant l'interface m�tier {@link IProduitService}
 *
 * @author Administrateur
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProduitService implements IProduitService {

    // insertion du logger pour ajouter le logg des requ�tes sql dans le fichier
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
    public List<ProduitDto> findFilter(final String searchTerm, final TypeTriAlphanumerique tri) {
        final StringBuilder buffy = new StringBuilder();
        buffy.append("Le produit {} findFilter a �t� appel� avec ");
        if (!searchTerm.isBlank()) {
            if (tri == null) {
                buffy.append("{} en param�tre de recherche, et aucun param�tre de tri");
                logger.debug(buffy.toString(), ProduitDto.class, searchTerm);
                return rechercherProduits(searchTerm);
            }
            buffy.append("{} en param�tre de recherche et {} en param�tre de tri");
            logger.debug(buffy.toString(), ProduitDto.class, searchTerm, tri.getTypeDao());
            return listerFiltreTri(tri, searchTerm);
        }
        if (tri == null) {
            buffy.append("aucun param�tre");
            logger.debug(buffy.toString(), ProduitDto.class);
            return listerProduitsEnVente();
        }
        buffy.append("aucun param�tre de recherche et {} en param�tre de tri");
        logger.debug(buffy.toString(), ProduitDto.class, tri.getTypeDao());
        return trierListe(tri);
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

    @Override
    public ProduitDto creerProduit(final ProduitDto produitDto) {
        final var produitDo = ProduitMapper.mapToDo(produitDto);
        this.logger.debug("Produit Service {} creerProduit", produitDto.getClass().getSimpleName());
        return ProduitMapper.mapToDto(produitDao.create(produitDo));
    }
}
