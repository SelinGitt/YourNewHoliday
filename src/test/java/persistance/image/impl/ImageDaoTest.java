/**
 * 
 */
package persistance.image.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import persistance.image.IImageDao;

/**
 * Classe test de ImageDao
 *
 * @author Lucas
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
@WebAppConfiguration("WebContent")
class ImageDaoTest {
    @Autowired
    private IImageDao imageDao;

    /**
     * Test method for {@link persistance.image.impl.ImageDaoTest#getImage(java.lang.String)}.
     */
    @Test
    void testGetImage() {
        final String path = "C:\\temp\\img\\frame.png";
        assertEquals("C:\\temp\\img\\frame.png", imageDao.getImage(path).getAbsolutePath());
    }

}
