/**
 * 
 */
package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        final String path = "C:\\temp\\img\\frame.png";
        assertEquals("C:\\temp\\img\\frame.png", imageService.getImage(path).getAbsolutePath());
    }

}
