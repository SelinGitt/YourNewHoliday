/**
 * 
 */
package service.image.impl;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.image.IImageDao;
import persistance.produit.dao.IProduitDao;
import persistance.utilisateur.dao.IUtilisateurDao;
import service.image.IImageService;
import service.image.TypeImage;
import service.util.GetPropertyValues;

/**
 * Classe représentant l'interface métier {@link IImageService}
 *
 * @author LucasNotAdmin
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ImageService implements IImageService {

    private static final Logger logger = LoggerFactory.getLogger(ImageService.class);

    @Autowired
    private IImageDao           imageDao;

    @Autowired
    private IProduitDao         produitDao;

    @Autowired
    private IUtilisateurDao     utilisateurDao;

    @Override
    public File getImage(final String id, final String type) {
        String path;
        if (TypeImage.PRODUIT.type.equals(type)) {
            final var produitDo = produitDao.findById(Integer.valueOf(id));
            path = GetPropertyValues.getPropertiesMap().get("imagesProduitsRepo") + produitDo.getCheminImage();
            return imageDao.getImage(path);
        }
        if (TypeImage.UTILISATEUR.type.equals(type)) {
            final var utilisateurDo = utilisateurDao.findById(Integer.valueOf(id));
            path = GetPropertyValues.getPropertiesMap().get("imagesUtilisateursRepo") + utilisateurDo.getCheminAvatar();
            return imageDao.getImage(path);
        }
        //ajouter le produitAcheteDao, indisponible à l'heure actuelle
        return null;
    }

    @Override
    public boolean saveImage(final byte[] byteArray, final String type, final String fileName) {
        //on test dans la couche présentation si image est null
        if (TypeImage.UTILISATEUR.type.equals(type)) {
            final var cheminComplet = GetPropertyValues.getPropertiesMap().get("imagesUtilisateursRepo") + File.separator + fileName;
            return imageDao.saveImage(cheminComplet, byteArray);
        }
        logger.debug("Le type {} du fichier ne correspond pas à utilisateur", type);
        return false;
    }

}
