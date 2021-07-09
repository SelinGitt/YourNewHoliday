/**
 * 
 */
package persistance.image.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

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
    public boolean saveImage(final String cheminTotal, final File image) {

        try (final FileOutputStream fos = new FileOutputStream(cheminTotal)) {
            final ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(image);
        } catch (final Exception e) {
            //TODO
            return false;
        }
        return true;
    }
}
