/**
 * 
 */
package persistance.image.impl;

import java.io.File;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import persistance.image.IImageDao;

/**
 * Classe chargeant l'image dans l'application
 *
 * @author Lucas
 */
@Repository
public class ImageDao implements IImageDao {

    private static final Logger logger = LoggerFactory.getLogger(ImageDao.class);

    @Override
    public File getImage(final String path) {
        return new File(path);
    }

    @Override
    public boolean saveImage(final String cheminTotal, final byte[] byteArray) {
        try (final FileOutputStream fos = new FileOutputStream(cheminTotal)) {
            fos.write(byteArray);
        } catch (final Exception e) {
            e.printStackTrace();
            logger.warn("Le fichier {} n'a pas pu être sauvegardé.", byteArray);
            return false;
        }
        return true;
    }
}
