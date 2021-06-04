/**
 * 
 */
package service.image.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import persistance.image.IImageDao;
import service.image.IImageService;

/**
 * Classe représentant l'interface métier {@link IImageService}
 *
 * @author LucasNotAdmin
 */
@Service
public class ImageService implements IImageService {

    @Autowired
    private IImageDao imageDao;

    @Override
    public File getImage(final String path) {
        return imageDao.getImage(path);
    }

}
