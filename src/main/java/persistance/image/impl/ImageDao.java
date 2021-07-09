/**
 * 
 */
package persistance.image.impl;

import java.io.File;

import org.springframework.stereotype.Repository;

import persistance.image.IImageDao;

/**
 * Classe chargant l'image dans l'application
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
    public File saveImage(final String cheminTotal, final File image) {

        return null;
    }

}
