/**
 * 
 */
package service.image.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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

    private static final Logger logger            = LoggerFactory.getLogger(ImageService.class);
    private static final int    LIMIT_WIDTH_USER  = 200;
    private static final int    LIMIT_HEIGHT_USER = 200;
    private static final int    LIMIT_SIZE_USER   = 500_000;

    @Autowired
    private IImageDao           imageDao;

    @Autowired
    private IProduitDao         produitDao;

    @Autowired
    private IUtilisateurDao     utilisateurDao;

    @Override
    public File getImage(final String id, final String type) {
        String path;
        if (TypeImage.PRODUIT.getType().equals(type)) {
            final var produitDo = produitDao.findById(Integer.valueOf(id));
            path = GetPropertyValues.getPropertiesMap().get("imagesProduitsRepo") + produitDo.getCheminImage();
            return imageDao.getImage(path);
        }
        if (TypeImage.UTILISATEUR.getType().equals(type)) {
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
        if (TypeImage.UTILISATEUR.getType().equals(type)) {
            final String cheminComplet = GetPropertyValues.getPropertiesMap().get("imagesUtilisateursRepo") + File.separator + fileName;
            //utilisatiion de l'écriture java 7 pour indiquer que le fichier ne doit pas dépasser 500ko
            final var imageEnregistree = imageDao.saveImage(cheminComplet, byteArray);
            final var imageValid = verifyFile(cheminComplet, LIMIT_WIDTH_USER, LIMIT_HEIGHT_USER, LIMIT_SIZE_USER);
            return imageEnregistree && imageValid;
        }
        logger.debug("Le type {} du fichier ne correspond pas à un type existant", type);
        return false;
    }

    /**
     * Permet de tester les paramètres d'un fichier
     * 
     * @param  f      le fichier a tester
     * @param  size   le poids du fichier a ne pas dépasser
     * @param  width  la largeur du fichier (doit être inférieur)
     * @param  height la hauteur du fichier (doit être inférieur)
     * @return        <code>true</code> si le fichier envoye correspond a une image<br>
     *                <code>false</code> dans le cas contraire
     */
    private boolean verifyFile(final String chemin, final int width, final int height, final int size) {
        final var file = new File(chemin);
        try {
            final var bufferImage = ImageIO.read(file);
            return !(bufferImage == null || isImageValid(bufferImage, height, width) || isFileValid(file, size));

        } catch (final IOException ioe) {
            logger.error("une exception {} a été levée pour le fichier {}", ioe, file);
            return false;
        }
    }

    private boolean isImageValid(final BufferedImage bufferImage, final int height, final int width) {
        return bufferImage.getWidth() > width || bufferImage.getHeight() > height;
    }

    private boolean isFileValid(final File file, final int size) {
        return file.length() > size;
    }

}
