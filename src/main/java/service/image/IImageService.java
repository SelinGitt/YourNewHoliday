/**
 * 
 */
package service.image;

import java.io.File;

import service.image.impl.ImageService;

/**
 * Interface m�tier de {@link ImageService}
 *
 * @author Lucas
 */
public interface IImageService {
    /**
     * Permet de r�cup�rer une image en fonction de son chemin absolu
     *
     * @param  type le type d'image a recuperer
     * @param  id   l'id a recuperer
     * @return      l'image dans un type file
     */
    File getImage(final String id, final String type);
}
