/**
 * 
 */
package presentation.produit.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import service.image.IImageService;

/**
 * Classe repr�sentant le controlleur d'upload d'image
 * 
 * @author Damien D.
 */
@Controller
@RequestMapping("/uploadImageProduit.do")
public class UploadImageProduitController {
    @Autowired
    private IImageService imageService;

    /**
     * Permet de mettre en ligne une image pour un produit
     * 
     * @param  part        ficher recu de l'upload
     * @return             le modelAndView de cr�er produit
     * @throws IOException en cas d'erreur de getBytes de part
     */
    @PostMapping
    public ModelAndView saveImage(@RequestParam("file") final MultipartFile part) throws IOException {
        final var modelAndView = new ModelAndView("redirect:creerProduitAdmin.do");
        final String fileName = part.getOriginalFilename();
        final byte[] byteArray = part.getBytes();
        final var imageResponse = imageService.saveImage(byteArray, "pdt", fileName);
        if (imageResponse.getError() == null) {
            modelAndView.getModelMap().addAttribute("image", fileName);
        } else {
            modelAndView.getModelMap().addAttribute("imgError", imageResponse.getError());

        }
        return modelAndView;

    }
}
