/**
 * 
 */
package service.produit.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import persistance.produit.dao.IProduitDao;
import persistance.produit.entity.ProduitDo;
import presentation.produit.controller.TypeTriAlphanumerique;
import presentation.produit.dto.ProduitDto;

/**
 * Classe test de {@link ProduitService}
 *
 * @author Administrateur
 */
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
        final var produitDo = new ProduitDo();
        produitDo.setPrixUnitaire(125d);
        final var produitDo2 = new ProduitDo();
        produitDo2.setPrixUnitaire(125d);
        // List.of permet de retourner une liste
        Mockito.when(this.iProduitDaoMock.findAll()).thenReturn(List.of(produitDo, produitDo2));
        assertEquals(2, this.produitServiceMock.listerAllProduit().size());
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#listerProduitsEnVente()}.
     */
    @Test
    void testListerProduitsEnVente() {
        final var produitDo = new ProduitDo();
        produitDo.setPrixUnitaire(125d);
        final var produitDo2 = new ProduitDo();
        produitDo2.setPrixUnitaire(125d);
        // List.of permet de retourner une liste
        Mockito.when(this.iProduitDaoMock.findAllProduitsEnVente()).thenReturn(List.of(produitDo, produitDo2));
        assertEquals(2, this.produitServiceMock.listerProduitsEnVente().size());
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#creerProduit(presentation.produit.dto.ProduitDto)}.
     */
    @Test
    void testCreerProduit() {
        final var produitDo = new ProduitDo();
        produitDo.setNom("Voyage en Tanzanie");
        produitDo.setReference("0125556789");
        produitDo.setHebergement("BouiBoui and Co.");
        produitDo.setDestination("Zanzibar");
        produitDo.setPrixUnitaire(125d);
        produitDo.setMiseEnVente(true);
        produitDo.setDescription("Super voyage � la d�couverte de zanzibar");

        final var produitDoCree = new ProduitDo();
        produitDo.setIdProduitOriginal(5);
        produitDo.setNom("Voyage en Tanzanie");
        produitDo.setReference("0125556789");
        produitDo.setHebergement("BouiBoui and Co.");
        produitDo.setDestination("Zanzibar");
        produitDo.setPrixUnitaire(125d);
        produitDo.setMiseEnVente(true);
        produitDo.setDescription("Super voyage � la d�couverte de zanzibar");

        Mockito.when(this.iProduitDaoMock.create(produitDo)).thenReturn(produitDoCree);
        final ProduitDo nouveauProduit = iProduitDaoMock.create(produitDo);
        assertNotNull(nouveauProduit);
        assertEquals(produitDoCree, nouveauProduit);
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#trouverProduitEnVente(java.lang.Integer)}.
     */
    @Test
    void testTrouverProduitEnVente() {
        final var produitDo = new ProduitDo();
        produitDo.setPrixUnitaire(125d);
        produitDo.setMiseEnVente(true);
        Mockito.when(this.iProduitDaoMock.findProduitEnVente(1)).thenReturn(produitDo);
        Mockito.when(this.iProduitDaoMock.findProduitEnVente(2)).thenReturn(null);
        // On r�cup�re un produit en vente
        assertNotNull(produitServiceMock.trouverProduitEnVente(1));
        // On essaie de r�cup�rer un produit qui n'est pas en vente
        assertNull(produitServiceMock.trouverProduitEnVente(2));
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#rechercherAllProduits(java.lang.Integer)}.
     */
    @Test
    void testRechercherAllProduits() {
        final var produitDo = new ProduitDo();
        produitDo.setIdProduitOriginal(99);
        produitDo.setNom("Test en Tanzanie");
        produitDo.setReference("TEST556789");
        produitDo.setHebergement("Test BouiBoui and Co.");
        produitDo.setDestination("Test Zanzibar");
        produitDo.setPrixUnitaire(125d);
        produitDo.setMiseEnVente(true);
        produitDo.setDescription("Test super voyage � la d�couverte de zanzibar");
        produitDo.setCheminImage("C:/YNH/img");
        produitDo.setVersion(1);
        produitDo.setServices(1);
        Mockito.when(this.iProduitDaoMock.rechercherAllProduits("TEST")).thenReturn(List.of(produitDo));
        Mockito.when(this.iProduitDaoMock.rechercherAllProduits("ZZZ")).thenReturn(Collections.emptyList());
        // On r�cup�re un produit en vente
        assertEquals(1, produitServiceMock.rechercherAllProduits("TEST").size());
        // On essaie de r�cup�rer un produit qui n'existe pas
        assertEquals(0, produitServiceMock.rechercherAllProduits("ZZZ").size());
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#findFilter(String,String)}.
     */
    @Test
    void testFindFilterWithRecherche() {
        Mockito.when(this.iProduitDaoMock.rechercherAllProduits("23")).thenReturn(Collections.emptyList());
        final List<ProduitDto> liste = produitServiceMock.findFilter("23", TypeTriAlphanumerique.findValue("not existing"));
        assertNotNull(liste);
        assertEquals(0, liste.size());
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#findFilter(String,String)}.
     */
    @Test
    void testFindFilterWithTri() {
        //cr�ation des produits
        final var produitDo = new ProduitDo();
        produitDo.setPrixUnitaire(1274d);
        final var produitDo2 = new ProduitDo();
        produitDo2.setPrixUnitaire(126d);
        final var produitDto = new ProduitDto();
        produitDto.setPrixUnitaire("1274,00");
        final var produitDto2 = new ProduitDto();
        produitDto2.setPrixUnitaire("126,00");
        //cr�ation de la liste � retourner
        final List<ProduitDo> listeTriee = List.of(produitDo2, produitDo);
        Mockito.when(this.iProduitDaoMock.trierListe(TypeTriAlphanumerique.DESC)).thenReturn(listeTriee);
        //attribution des listes de produitDto, une tri�e, et une non tri�e qui sera tri�e par une m�thode java
        final List<ProduitDto> liste = produitServiceMock.findFilter("", TypeTriAlphanumerique.findValue("2"));
        final List<ProduitDto> listeNonTriee = new ArrayList<>();
        listeNonTriee.addAll(List.of(produitDto, produitDto2));
        //cr�ation d'un comparator pour pr�parer le tri via java
        final Comparator<ProduitDto> produitDoPrixComparator = Comparator.comparing(ProduitDto::getPrixUnitaire);
        Collections.sort(listeNonTriee, produitDoPrixComparator);
        assertEquals(liste.stream().findFirst().get().getPrixUnitaire(), listeNonTriee.stream().findFirst().get().getPrixUnitaire());
        assertEquals(liste.stream().skip(1).findFirst().get().getPrixUnitaire(),
                listeNonTriee.stream().skip(1).findFirst().get().getPrixUnitaire());
    }

}