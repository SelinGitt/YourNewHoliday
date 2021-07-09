/**
 * 
 */
package persistance.image.impl;

import java.io.File;

import org.springframework.stereotype.Repository;

import persistance.image.IImageDao;

/**
 * Classe chargeant l'image dans l'application
 *
 * @author Lucas
 */
@Repository
public class ImageDao implements IImageDao {

    @Override
    public File getImage(final String path) {
        return new File(path);
    }

    @Override
    public boolean saveImage(String cheminTotal, final File image) {
        if (image != null) {
            final String file = image.getAbsolutePath();
            //cheminTotal = PATH_NAME + File.separator + file;
            return true;
        }
        return false;
    }

}
