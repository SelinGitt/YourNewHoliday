/**
 * 
 */
package service.image;

import java.io.File;

import service.image.impl.ImageService;

/**
 * Interface métier de {@link ImageService}
 *
 * @author Lucas
 */
public interface IImageService {
    /**
     * Permet de récupérer une image en fonction de son chemin absolu
     *
     * @param  type le type d'image a recuperer
     * @param  id   l'id a recuperer
     * @return      l'image dans un type file
     */
    File getImage(final String id, final String type);

    /**
     * Permet de sauvegarder le chemin complet de l'image
     *
     * @param  byteArray le fichier
     * @param  type      le type de fichier
     * @param  fileName  le nom du fichier à importer
     * @return           vrai si sauvegardé
     */
    boolean saveImage(final byte[] byteArray, final String type, final String fileName);
}
