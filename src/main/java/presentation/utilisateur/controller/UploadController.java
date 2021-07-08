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
    private static final String PATH_NAME = "C:/YNH_Project/external_files/img/utilisateurs/";

    protected void saveImage(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        //si vous voulez créer un dossier spécial par client, vous devrez le placer en paramètre ici, à la place de PATH_NAME (rajouter "\\{ReferenceClient}")
        final File uploadDir = new File(PATH_NAME);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        for (final Part part : request.getParts()) {
            final String fileName = Image.getFileName(part);
            final String fullPath = PATH_NAME + File.separator + fileName;
            request.setAttribute("image_Path", fullPath);
            final File f = new File(fullPath);
            try {
                part.write(fullPath);
            } catch (final IOException ioe) {
                ioe.printStackTrace();
            }
            if (!Image.isOk(f)) {
                f.delete();
                //Il n'y a pas de gestion d'erreur, pour l'instant
                response.sendRedirect("UploadServlet.do");
                return;
            }
            request.getRequestDispatcher("DisplayImage.do").forward(request, response);
        }
    }
}
