/**
 * 
 */
package service.produit.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.produit.dao.IProduitDao;
import persistance.produit.entity.ProduitDo;

/**
 * Classe test de {@link ProduitService}
 *
 * @author Administrateur
 */
@WebAppConfiguration("WebContent")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
//Utilisation d'une transaction pour avoir des auto rollbacks à chaque fin de tests
@Transactional(propagation = Propagation.REQUIRED)
class ProduitServiceTest {

    @InjectMocks
    private ProduitService produitServiceMock;
    @Mock
    private IProduitDao    iProduitDaoMock;

    @BeforeEach
    void initMock() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#listerAllProduit()}.
     */
    @Test
    void testListerAllProduit() {
        // SingletonList permet de retourner une liste avec 1 élement
        final var produitDo = new ProduitDo();
        produitDo.setPrixUnitaire(125d);
        Mockito.when(this.iProduitDaoMock.findAll()).thenReturn(Collections.singletonList(produitDo));
        assertEquals(1, this.produitServiceMock.listerAllProduit().size());
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#listerProduitsEnVente()}.
     */
    @Test
    void testListerProduitsEnVente() {
        // SingletonList permet de retourner une liste avec 1 élement
        final var produitDo = new ProduitDo();
        produitDo.setPrixUnitaire(125d);
        Mockito.when(this.iProduitDaoMock.findAllProduitsEnVente()).thenReturn(Collections.singletonList(produitDo));
        assertEquals(1, this.produitServiceMock.listerProduitsEnVente().size());
    }
}
