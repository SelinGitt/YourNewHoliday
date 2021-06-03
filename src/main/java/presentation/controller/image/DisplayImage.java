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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Classe controller pour afficher une image dans une jsp
 *
 * @author LucasNotAdmin
 */
@Controller
@RequestMapping("/DisplayImage.do")
public class DisplayImage {
    private static final Logger logger = LoggerFactory.getLogger(DisplayImage.class);

    /**
     * Permet d'afficher une image en focntion de son chemin en paramètre. <br>
     * Le paramètre demandé en <b>GET</b> est la chaine de caractère du chemin absolu de l'image <br>
     * <i> ex: C:/temp/img/image.jpg</i> <br>
     * Pour appeler cette méthode depuis une JSP; il suffit juste de prendre une balise img avec le src qui est égal à cette
     * page et le path du paramètre. <br>
     * ex: <<i>img src="DisplayImage.do?path=C:/temp/img/image.jpg"</i>><br>
     * 
     * @param response permet d'écrire dans une servlet
     * @param path     le chemin de l'image
     */
    @GetMapping
    public void showImage(final HttpServletResponse response, final @RequestParam("path") String path) {
        try (final var servletOutputStream = response.getOutputStream();
                final var fileInputStream = new FileInputStream(path);
                final var bufferedInputStream = new BufferedInputStream(fileInputStream);
                final var bufferedOutputStream = new BufferedOutputStream(servletOutputStream);) {

            var ch = 0;
            while ((ch = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(ch);
            }
        } catch (final IOException ioe) {
            logger.debug(ioe.getLocalizedMessage());
        }
    }
}
