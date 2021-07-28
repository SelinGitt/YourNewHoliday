/**
 * 
 */
package persistance.image;

import java.io.File;

import persistance.image.impl.ImageDao;

/**
 * Interface persistence de la classe {@link ImageDao}
 *
 * @author LucasNotAdmin
 */
public interface IImageDao {

    /**
     * Permet de retrouver une image localement en fonction de son chemin absolu
     *
     * @param  path le chemin absolu de l'image
     * @return      l'image dans un fichier
     */
    File getImage(final String path);

    /**
     * Permet de sauvegarder une image dans le disque dur du PC.
     *
     * @param  cheminTotal chemin complet de l'avatar
     * @param  byteArray   le fichier sauvegarder
     * @return             vrai si fichier sauvegard
     */
    boolean saveImage(final String cheminTotal, final byte[] byteArray);
}
