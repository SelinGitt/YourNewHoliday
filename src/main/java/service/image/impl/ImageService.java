/**
 * 
 */
package service.image.impl;

import java.io.File;

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

    @Autowired
    private IImageDao       imageDao;

    @Autowired
    private IProduitDao     produitDao;

    @Autowired
    private IUtilisateurDao utilisateurDao;

    @Override
    public File getImage(final String id, final String type) {
        String path;
        if (TypeImage.PRODUIT.type.equals(type)) {
            final var produitDo = produitDao.findById(Integer.valueOf(id));
            path = GetPropertyValues.PROPERTIESMAP.get("imagesProduitsRepo") + produitDo.getCheminImage();
            return imageDao.getImage(path);
        }

        if (TypeImage.UTILISATEUR.type.equals(type)) {
            final var userDo = utilisateurDao.findById(Integer.valueOf(id));
            path = GetPropertyValues.PROPERTIESMAP.get("imagesUtilisateursRepo") + userDo.getCheminAvatar();
            return imageDao.getImage(path);
        }
        // il faut ajouter le produitAcheteDao, indisponible à l'heure actuelle
        return null;
    }

    @Override
    public boolean saveImage(final File image, final String type) {
        if (image != null) {
            if (TypeImage.UTILISATEUR.type.equals(type)) {
                final var file = image.getAbsolutePath();
                final var cheminComplet = GetPropertyValues.PROPERTIESMAP.get("imagesUtilisateursRepo") + File.separator + file;
                imageDao.saveImage(cheminComplet, image);
                return true;
            }
        }
        return false;
    }

}
