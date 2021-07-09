/**
 * 
 */
package presentation.utilisateur.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.image.Image;

/**
 * Controller pour upload d'une image
 *
 * @author Selin
 */
@Controller
@RequestMapping("/upload.do")
public class UploadController {

    /**
     * Attribute of Path Name
     */
    private static final String PATH_NAME = "C:/YNH_Project/external_files/img/utilisateurs";

    //  préparation du logger pour la gestion des erreurs/de la validation
    private static final Logger logger    = LoggerFactory.getLogger(UploadController.class);

    public void recupererImage(final HttpServletResponse response, final String type) {

    }

    /**
     * Permet de sauvegarder l'image dans le disque dur du PC
     *
     * @param  request          la requête
     * @param  response         la réponse
     * @throws ServletException la servlet exception
     * @throws IOException      l'exception
     */
    public void saveImage(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        //        final File uploadDir = new File(PATH_NAME);
        //        if (!uploadDir.exists()) {
        //            uploadDir.mkdirs();
        //        }
        for (final Part part : request.getParts()) {
            final String fileName = Image.getFileName(part);
            final String fullPath = PATH_NAME + File.separator + fileName;
            final File f = new File(fullPath);
            try {
                part.write(fullPath);
            } catch (final IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
