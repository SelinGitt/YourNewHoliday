/**
 * 
 */
package presentation.utilisateur.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import service.image.IImageService;
import service.image.TypeImage;

/**
 * Classe repr�sentant le controlleur d'upload d'image
 * 
 * @author Lucas
 */
@Controller
@RequestMapping("/uploadImageUser.do")
public class UploadImageUserController {
    @Autowired
    private IImageService imageService;

    /**
     * Permet de mettre en ligne une image pour un utilisateur
     * 
     * @param  part        ficher recu de l'upload
     * @return             le modelAndView de cr�er user
     * @throws IOException en cas d'erreur de getBytes de part
     */
    @PostMapping
    public ModelAndView saveImage(@RequestParam("file") final MultipartFile part) throws IOException {
        final var modelAndView = new ModelAndView("redirect:creerUtilisateur.do");
        final String fileName = part.getOriginalFilename();
        final byte[] byteArray = part.getBytes();
        final var imageError = imageService.saveImage(byteArray, TypeImage.UTILISATEUR.getType(), fileName);
        if (imageError.getError() == null) {
            modelAndView.getModelMap().addAttribute("avatar", fileName);
        } else {
            modelAndView.getModelMap().addAttribute("imgError", imageError.getError());

        }
        return modelAndView;

    }
}
