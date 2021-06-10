/**
 * 
 */
package presentation.controller.image;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.image.IImageService;

/**
 * Classe controller pour afficher une image dans une jsp
 *
 * @author Lucas
 */
@Controller
@RequestMapping("/DisplayImage.do")
public class DisplayImage {
    private static final Logger logger = LoggerFactory.getLogger(DisplayImage.class);

    @Autowired
    private IImageService       imageService;

    /**
     * Permet d'afficher une image en fonction de son id et de son type en paramètre. <br>
     * Le paramètre demandé en <b>GET</b> est l'id recherché ainsi que son type.<br>
     * ex:<i>id=1&type=pdt</i><br>
     * Pour appeler cette méthode depuis une JSP; il suffit juste de prendre une balise img avec le src qui est égal à cette
     * page et l'id et le type de ce que vous voulez. <br>
     * Pour connaitre les types que vous pouvez utiliser, regardez l'enum {@link service.image.TypeImage} <br>
     * ex: <<i>img src="DisplayImage.do?id=1&type=pdt"</i>><br>
     * 
     * @param response permet d'écrire dans une servlet
     * @param id       l'id à rechercher
     * @param type     le type d'image
     */
    @GetMapping
    public void showImage(final HttpServletResponse response, final @RequestParam("id") String id,
            final @RequestParam("type") String type) {
        try (final var servletOutputStream = response.getOutputStream();
                final var fileInputStream = new FileInputStream(imageService.getImage(id, type));
                final var bufferedInputStream = new BufferedInputStream(fileInputStream);
                final var bufferedOutputStream = new BufferedOutputStream(servletOutputStream)) {

            var byteToWrite = 0;
            while ((byteToWrite = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(byteToWrite);
            }
        } catch (final IOException ioe) {
            logger.warn(ioe.getMessage(), ioe);
        }
    }
}
