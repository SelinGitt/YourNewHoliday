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
import service.image.IImageService;
import service.image.TypeImage;
import service.util.GetPropertyValues;

/**
 * Classe repr�sentant l'interface m�tier {@link IImageService}
 *
 * @author LucasNotAdmin
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ImageService implements IImageService {

    @Autowired
    private IImageDao   imageDao;

    @Autowired
    private IProduitDao produitDao;

    @Override
    public File getImage(final String id, final String type) {
        String path;
        if (TypeImage.PRODUIT.type.equals(type)) {
            final var produitDo = produitDao.findById(Integer.valueOf(id));
            path = GetPropertyValues.getPropertiesMap().get("imagesProduitsRepo") + produitDo.getCheminImage();
            return imageDao.getImage(path);
        }
        //ajouter l'utilisateurDao et le produitAcheteDao, indisponible � l'heure actuelle
        return null;
    }

}
