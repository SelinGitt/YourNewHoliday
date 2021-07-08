/**
 * 
 */
package service.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.Part;

/**
 * Classe permettant de gerer une image
 *
 * @author Selin
 */
public class Image {

    /**
     * Récupération du nom du fichier dans la requête.
     * 
     * @param  part recuperation de multipart
     * @return      le nom du fichier
     */
    public static String getFileName(final Part part) {
        for (final String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return "Default.file";
    }

    /**
     * Permet de tester le format et l'extension d'un fichier. <br>
     * Si un fichier en .exe est renommé en .png, alors ce test échouera, car le contenu du fichier ne correspond pas à une
     * image <br>
     * En revanche, si un PNG (ou tout autre format d'image comme précisé dans LISTE_EXTENSION est renommé en un fichier non
     * accepté, alors le fichier ne sera pas mis en ligne, même si reconnu dans la prévisualistation. Cette méthode accepte
     * tout en deçà de la limite fournie par le multipartconfig
     * 
     * @param  f le fichier a tester
     * @return   <code>true</code> si le fichier envoye correspond a une image<br>
     *           <code>false</code> dans le cas contraire
     */
    public static boolean isOk(final File f) {
        try {
            final BufferedImage bufferImage = ImageIO.read(f);
            final String[] findExtension = f.getName().split("\\.");
            final String extension = findExtension[findExtension.length - 1];
            if (bufferImage == null || Extensions.isIn(extension.toLowerCase())) {
                return false;
            }
            return true;

        } catch (

        final IOException ioe) {
            ioe.printStackTrace();
            return false;
        }
    }

    /**
     * Permet de tester le format et l'extension d'un fichier. <br>
     * Si un fichier en .exe est renommé en .png, alors ce test échouera, car le contenu du fichier ne correspond pas à une
     * image <br>
     * En revanche, si un PNG (ou tout autre format d'image comme précisé dans LISTE_EXTENSION est renommé en un fichier non
     * accepté, alors le fichier ne sera pas mis en ligne, même si reconnu dans la prévisualistation.
     * 
     * @param  f      le fichier a tester
     * @param  size   le poids du fichier a ne pas dépasser
     * @param  width  la largeur du fichier (doit être égal)
     * @param  height la hauteur du fichier (doit être égal)
     * @return        <code>true</code> si le fichier envoye correspond a une image<br>
     *                <code>false</code> dans le cas contraire
     */
    public static boolean isOk(final File f, final Integer size, final Integer width, final Integer height) {
        try {
            final BufferedImage bufferImage = ImageIO.read(f);
            //Pour limiter la taille d'une image > if (f.length() > 1024 * 1024) : 1024 * 1024 OCTETS 
            //pour limiter la largeur d'une image > if (bimg.getWidth() > 1920)
            //Pour limiter la hauteur d'une image > if (bimg.getHeight() > 1080)
            if (isOk(f) || bufferImage.getWidth() == width || bufferImage.getHeight() == height || f.length() < size) {
                return false;
            }
            return true;

        } catch (final IOException ioe) {
            ioe.printStackTrace();
            return false;
        }
    }

}
