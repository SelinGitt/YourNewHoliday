/**
 * 
 */
package service.image.impl;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import persistance.image.IImageDao;
import persistance.produit.dao.IProduitDao;
import persistance.produit.entity.ProduitDo;
import service.image.IImageService;

/**
 * Classe test de IImageService
 *
 * @author Lucas
 */
class ImageServiceTest {
    @InjectMocks
    private static final IImageService imageService = new ImageService();
    @Mock
    private IImageDao                  imageDao;
    @Mock
    private IProduitDao                iProduitDao;

    @BeforeEach
    void initMock() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test method for {@link service.image.impl.ImageService#getImage(java.lang.String)}.
     */
    @Test
    void testGetImage() {
        final var produitDo = new ProduitDo();
        produitDo.setCheminImage("c:/temp/img/maldives.jpg");
        when(this.iProduitDao.findById(Mockito.anyInt())).thenReturn(produitDo);

        when(this.imageDao.getImage(Mockito.anyString())).thenReturn(new File("src/test/resources/img/dummyImage.jpg"));
        final var file = imageService.getImage("1", "pdt");
        assertTrue(file.exists());

    }

    /**
     * Test method for {@link service.image.impl.ImageService#getImage(java.lang.String)}.
     */
    @Test
    void testGetImageReturnsNull() {
        final var produitDo = new ProduitDo();
        produitDo.setCheminImage("c:/temp/img/maldives.jpg");
        when(this.iProduitDao.findById(Mockito.anyInt())).thenReturn(produitDo);

        when(this.imageDao.getImage(Mockito.anyString())).thenReturn(new File("src/test/resources/img/dummyImage.jpg"));
        final var file = imageService.getImage("1", "ShouldReturnNull");
        assertNull(file);

    }
}
