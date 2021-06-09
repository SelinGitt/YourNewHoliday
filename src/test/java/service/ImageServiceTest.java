/**
 * 
 */
package service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import service.image.IImageService;

/**
 * Classe test de IImageService
 *
 * @author Lucas
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
@WebAppConfiguration("WebContent")
class ImageServiceTest {
    @Autowired
    private IImageService imageService;

    /**
     * Test method for {@link service.image.impl.ImageService#getImage(java.lang.String)}.
     */
    @Test
    void testGetImage() {
        final var path = "C:\\temp\\img\\maldives.jpg";
        final var file = new File(path);
        assertNotNull(imageService.getImage("1", "pdt"));
        assertTrue(file.exists());

    }

}
