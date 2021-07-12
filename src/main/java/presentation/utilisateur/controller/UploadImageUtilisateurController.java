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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import service.image.IImageService;
import service.image.Image;

/**
 * Controller pour upload d'une image
 *
 * @author Selin
 */
@Controller
@RequestMapping("/upload.do")
public class UploadImageUtilisateurController {

    @Autowired
    private IImageService       iImageService;

    /**
     * Attribute of Path Name
     */
    private static final String PATH_NAME = "C:/YNH_Project/external_files/img/utilisateurs";

    /**
     * Permet de XX
     *
     * @param response une réponse
     * @param type     le type d'image
     */
    public void recupererImage(final HttpServletResponse response, final String type) {
        //empty now
    }

    /**
     * Permet de sauvegarder l'image dans le disque dur du PC
     *
     * @param  request          la requête
     * @param  response         la réponse
     * @throws ServletException la servlet exception
     * @throws IOException      l'exception
     */
    @PostMapping
    public void saveImage(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        for (final Part part : request.getParts()) {
            final String fileName = Image.getFileName(part);
            final File f = new File(fileName);
            final var result = iImageService.saveImage(f, "usr");
            System.out.println(result);

            //  si l'image n'est pas conforme, le fichier est supprimé
            if (!Image.isOk(f)) {
                f.delete();
                return;
            }
        }
    }
}
