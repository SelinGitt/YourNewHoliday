/**
 * 
 */
package persistance.image.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Classe test de ImageDao
 *
 * @author Lucas
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
@WebAppConfiguration("WebContent")
class ImageDaoTest {

    @InjectMocks
    private ImageDao imageDao;

    /**
     * Test method for {@link persistance.image.impl.ImageDaoTest#getImage(java.lang.String)}.
     */
    @Test
    void testGetImage() {
        final var path = "C:\\YNH_Project\\external_files\\img\\produits\\maldives.jpg";
        final var file = new File(path);
        assertEquals("C:\\YNH_Project\\external_files\\img\\produits\\maldives.jpg", imageDao.getImage(path).getAbsolutePath());
        assertTrue(file.exists());
    }
}
