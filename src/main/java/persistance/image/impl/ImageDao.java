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

    /**
     * Attribute of Path Name
     */
    private static final String PATH_NAME = "C:/YNH_Project/external_files/img/utilisateurs";

    @Override
    public File getImage(final String path) {
        return new File(path);
    }

    @Override
    public boolean saveImage(String cheminTotal, final File image) {
        if (image != null) {
            String file = image.getAbsolutePath();
            cheminTotal = PATH_NAME + File.separator + file;
            return true;
        }
        return false;
    }

}
