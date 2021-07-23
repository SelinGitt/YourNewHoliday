/**
 * 
 */
package presentation.image;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.image.IImageService;
import service.image.Image;

/**
 * Classe représentant XX
 *
 * @author Lucas
 */
@Controller
@RequestMapping("/uploadImage.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadImage {
    @Autowired
    private IImageService imageService;

    /**
     * Permet de XX
     *
     * @param  request
     * @param  response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @PostMapping
    public ModelAndView saveImage(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        final var modelAndView = new ModelAndView();
        for (final Part part : request.getParts()) {
            System.out.println(part);
            final String fileName = Image.getFileName(part);
            final File f = new File(fileName);
            final var result = imageService.saveImage(f, "usr");
            System.out.println(result);
            try {
                part.write(fileName);
            } catch (final IOException ioe) {
                ioe.printStackTrace();
            }
            //  si l'image n'est pas conforme, le fichier est supprimé
            if (!Image.isOk(f)) {
                f.delete();
            }
        }
        return modelAndView;

    }
}