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
     * @param  path le chemin absolu
     * @return      l'image dans un type file
     */
    File getImage(final String path);
}
