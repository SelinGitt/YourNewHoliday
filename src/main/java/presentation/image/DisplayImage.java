/**
 * 
 */
package presentation.image;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
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
@RequestMapping("/displayImage.do")
public class DisplayImage {
    private static final Logger logger = LoggerFactory.getLogger(DisplayImage.class);

    @Autowired
    private IImageService       imageService;

    /**
     * <pre>
     * Permet d'afficher une image en fonction de son id et de son type en paramètre.
     * Le paramètre demandé en <b>GET</b> est l'id recherché ainsi que son type.
     * ex:{@code <i>id=1&type=pdt</i>}
     * Pour appeler cette méthode depuis une JSP; il suffit juste de prendre une balise img avec le src qui est égal à cette
     * page et l'id et le type de ce que vous voulez.
     * Pour connaitre les types que vous pouvez utiliser, regardez l'enum {@link service.image.TypeImage}
     * ex: {@code <<i>img src="DisplayImage.do?id=1&type=pdt"</i>>}
     * </pre>
     * 
     * @param response permet d'écrire dans une servlet
     * @param id       l'id à rechercher
     * @param type     le type d'image
     * @param avatar   nom du fichier à afficher
     */
    @GetMapping
    public void showImage(final HttpServletResponse response, final @RequestParam(value = "id", required = false) String id,
            final @RequestParam(value = "type") String type, final @RequestParam(value = "avatar", required = false) String avatar) {
        File file;
        if (id == null) {
            file = imageService.getImageFromDiskWithPath(avatar, type);
        } else {
            file = imageService.getImage(id, type);
        }
        try (final var servletOutputStream = response.getOutputStream();
                final var fileInputStream = new FileInputStream(file);
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
