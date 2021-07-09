/**
 * 
 */
package presentation.utilisateur.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller pour upload d'une image
 *
 * @author Selin
 */
@Controller
@RequestMapping("/upload.do")
public class UploadController {

    //  pr�paration du logger pour la gestion des erreurs/de la validation
    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    public void recupererImage(final HttpServletResponse response, final String type) {

    }

    /**
     * Permet de sauvegarder l'image dans le disque dur du PC
     *
     * @param  request          la requ�te
     * @param  response         la r�ponse
     * @throws ServletException la servlet exception
     * @throws IOException      l'exception
     */
    public void saveImage(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        //EMPTY
    }
}
