/**
 * 
 */
package persistance.produit.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import persistance.produit.dao.IProduitDao;
import persistance.produit.entity.ProduitDo;

/**
 * Classe repr�sentant les tests unitaires pour produitDao
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
// Permet de g�rer le JUnit avec Spring
@ExtendWith(SpringExtension.class)
//Et de d�clarer le fichier de conf � utiliser
@ContextConfiguration(locations = {"/META-INF/spring/applicationContext.xml", "/spring/hibernate-context-test.xml"})
//Pour initialiser la base de donn�es avec les bonnes donn�es 
@Sql("/sql/DML.sql")
@WebAppConfiguration("WebContent")
//N�cessaire car les Dao sont en Mandatory
@Transactional(propagation = Propagation.REQUIRED)
class ProduitDaoTest {

    @Autowired
    private IProduitDao iProduitDao;

    /**
     * Test method for {@link persistance.commun.dao.impl.AbstractGenericDao#findAll()}.
     */
    @Test
    void testFindAll() {
        // On r�cup�re les donn�es
        final List<ProduitDo> listProduit = this.iProduitDao.findAll();
        // On teste la conformit�e du nombre de donn�es
        assertEquals(6, listProduit.size());
    }

    /**
     * Test method for {@link persistance.produit.dao.impl.ProduitDao#findAllProduitsEnVente()}.
     */
    @Test
    void testFindAllProduitsEnVente() {
        // On r�cup�re la liste des produits en vente
        final List<ProduitDo> listeProduitDoEnVente = iProduitDao.findAllProduitsEnVente();
        // Test de la taille de la liste des produits en vente
        assertEquals(4, listeProduitDoEnVente.size());
    }

    /**
<<<<<<< HEAD
     * Test method for {@link persistance.produit.dao.impl.ProduitDao#findProduitEnVente(java.lang.Integer)}.
     */
    @Test
    void testFindProduitEnVente() {
        // On r�cup�re un produit en vente
        final ProduitDo produitDoEnVente = iProduitDao.findProduitEnVente(3);
        assertNotNull(produitDoEnVente);
        // On essaie de r�cup�rer un produit qui n'est pas en vente
        final ProduitDo produitDoPasEnVente = iProduitDao.findProduitEnVente(2);
        assertNull(produitDoPasEnVente);
=======
     * Test method for {@link persistance.produit.dao.impl.ProduitDao#rechercherProduits()}.
     */
    @Test
    void testRechercherProduits() {
        //recherche d'une r�f�rence 128 existente
        final String searchTerm = "128";
        final List<ProduitDo> listeProduitsRecherchee = iProduitDao.rechercherProduits(searchTerm);
        assertEquals(1, listeProduitsRecherchee.size());
        //recherche r�f�rence non existente
        final String searchTerm2 = "ZZZ";
        final List<ProduitDo> listeProduitsRecherchee2 = iProduitDao.rechercherProduits(searchTerm2);
        assertEquals(0, listeProduitsRecherchee2.size());
>>>>>>> develop
    }

    /**
     * Test method for {@link persistance.commun.dao.impl.AbstractGenericDao#findById(Integer)}.
     */
    @Test
    void testFindById() {
        //on r�cup�re un produit qui est en vente
        final var produitEnVente = iProduitDao.findById(1);
        assertNotNull(produitEnVente);
        assertEquals(1, produitEnVente.getIdProduitOriginal());
        assertEquals(2, produitEnVente.getVersion());
        assertEquals("125693", produitEnVente.getReference());
        assertEquals("Voyage aux Maldives", produitEnVente.getNom());
        assertEquals("description1", produitEnVente.getDescription());
        assertEquals("Maldives", produitEnVente.getDestination());
        assertEquals(900.00, produitEnVente.getPrixUnitaire());
        assertEquals("Maison dHotes", produitEnVente.getHebergement());
        assertTrue(produitEnVente.getMiseEnVente());
        assertEquals("D:....", produitEnVente.getCheminImage());
        assertEquals(1, produitEnVente.getServices());
        final var produitNonExistant = iProduitDao.findById(444);
        assertNull(produitNonExistant);
    }
}