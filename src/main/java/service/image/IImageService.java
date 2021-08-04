/**
 * 
 */
package service.image;

import java.io.File;

import service.image.impl.ImageService;
import service.image.util.ImageValidResponse;

/**
 * Interface métier de {@link ImageService}
 *
 * @author Lucas
 */
public interface IImageService {
    /**
     * Permet de récupérer une image en fonction de son id et de son type
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
     * @return           un objet retour avec un boolean si la sauvegarde de l'image a été réussie, false sinon, et un
     *                   message d'erreur si l'image n'a pas été sauvegardée
     */
    ImageValidResponse saveImage(final byte[] byteArray, final String type, final String fileName);

    /**
     * Permet de récupérer une image en fonction de son chemin absolu et de son type
     *
     * @param  path le chemin de l'image
     * @param  type le type de l'image
     * @return      l'image dans un type file
     */
    File getImageFromDiskWithPath(final String path, final String type);
}
