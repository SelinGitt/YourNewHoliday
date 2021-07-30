/**
 * 
 */
package service.image.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
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
import service.image.util.ImageValidResponse;
import service.util.GetPropertyValues;

/**
 * Classe repr�sentant l'interface m�tier {@link IImageService}
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
        final var typeImage = TypeImage.getTypeImage(type);
        if (typeImage == null) {
            return null;
        }
        String cheminImage = null;
        final var idInteger = Integer.valueOf(id);
        switch (typeImage) {
            case PRODUIT:
                final var produitDo = produitDao.findById(idInteger);
                logger.debug("Service - R�cup�ration de l'image de produit d'id : {}.", id);
                cheminImage = produitDo.getCheminImage();
                break;
            case UTILISATEUR:
                final var utilisateurDo = utilisateurDao.findById(idInteger);
                logger.debug("Service - R�cup�ration de l'avatar de l'utilisateur d'id : {}.", id);
                cheminImage = utilisateurDo.getCheminAvatar();
                break;
            //ajouter le produitAcheteDao, indisponible � l'heure actuelle
            default:
                return null;
        }
        return this.constructPath(typeImage, cheminImage);
    }

    private File constructPath(final TypeImage type, final String cheminImage) {
        final var path = GetPropertyValues.getPropertiesMap().get(type.getImageRepo()) + cheminImage;
        return imageDao.getImage(path);
    }

    @Override
    public ImageValidResponse saveImage(final byte[] byteArray, final String type, final String fileName) {
        final var typeImage = TypeImage.getTypeImage(type);
        if (typeImage == null) {
            logger.debug("Le type {} du fichier ne correspond pas � un type existant", type);
            return new ImageValidResponse.ImageValidResponseBuilder().withError("glb.img.erreur.image").build();
        }
        return this.saveImage(byteArray, typeImage, fileName);
    }

    private ImageValidResponse saveImage(final byte[] byteArray, final TypeImage type, final String fileName) {
        final var cheminComplet = GetPropertyValues.getPropertiesMap().get(type.getImageRepo()) + File.separator + fileName;
        final var imageValid = verifyFile(type.getWidth(), type.getHeight(), type.getSize(), byteArray);
        if (imageValid.getError() == null) {
            logger.debug("Service - Image produit nom:{} sauvegard�e � : {}.", fileName, cheminComplet);
            if (imageDao.saveImage(cheminComplet, byteArray)) {
                return imageValid;
            }
            return new ImageValidResponse.ImageValidResponseBuilder().withError("glb.img.erreur.image").build();
        }
        return imageValid;

    }

    /**
     * Permet de tester les param�tres d'un fichier
     * 
     * @param  f      le fichier a tester
     * @param  size   le poids du fichier a ne pas d�passer
     * @param  width  la largeur du fichier (doit �tre inf�rieur)
     * @param  height la hauteur du fichier (doit �tre inf�rieur)
     * @return        <code>true</code> si le fichier envoye correspond a une image<br>
     *                <code>false</code> dans le cas contraire
     */
    private ImageValidResponse verifyFile(final int width, final int height, final int size, final byte[] byteArray) {
        try {
            final var bufferImage = ImageIO.read(new ByteArrayInputStream(byteArray));
            if (isImageValid(bufferImage, height, width)) {
                return new ImageValidResponse.ImageValidResponseBuilder().withError("glb.img.erreur.ImageTooBig").build();
            }
            if (isFileValid(byteArray, size)) {
                return new ImageValidResponse.ImageValidResponseBuilder().withError("glb.img.erreur.ImageTooLarge").build();
            }
        } catch (final IOException ioe) {
            logger.error("une exception a �t� lev�e pour le fichier : ", ioe);
        }
        return new ImageValidResponse.ImageValidResponseBuilder().withData(byteArray).build();
    }

    private boolean isImageValid(final BufferedImage bufferImage, final int height, final int width) {
        return bufferImage.getWidth() > width || bufferImage.getHeight() > height;
    }

    private boolean isFileValid(final byte[] byteArray, final int size) {
        return byteArray.length > size;
    }

    @Override
    public File getImageFromDiskWithPath(final String path, final String type) {
        final var typeImage = TypeImage.getTypeImage(type);
        if (typeImage == null) {
            return null;
        }
        final var cheminComplet = GetPropertyValues.getPropertiesMap().get(typeImage.getImageRepo()) + File.separator + path;
        return imageDao.getImage(cheminComplet);
    }

}
