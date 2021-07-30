/**
 * 
 */
package service.produit.impl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
import presentation.panier.dto.PanierDto;
import presentation.produit.controller.TypeFiltre;
import presentation.produit.controller.TypeTriAlphanumerique;
import presentation.produit.dto.BeanQuantite;
import presentation.produit.dto.ProduitDto;
import service.panier.IPanierService;
import service.produit.ProduitMapper;
import service.utilisateur.util.UtilisateurRoleEnum;

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
    @Mock
    private IPanierService iPanierService;

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
        Mockito.when(this.iProduitDaoMock.findAllProduitsTriAlpha()).thenReturn(List.of(produitDo, produitDo2));
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
    void testCreerProduitInexistantEnBase() {
        final Boolean[] boolArrayToTest = {false, false, false, false, false, false, false, false, true};
        final var produitDto = new ProduitDto();
        produitDto.setIdProduitOriginal("99");
        produitDto.setNom("Test Edition");
        produitDto.setReference("TEST00000");
        produitDto.setPrixUnitaire("10.00");
        produitDto.setServices(boolArrayToTest);
        produitDto.setMiseEnVente("true");
        produitDto.setHebergement("Hotel Test");
        produitDto.setDestination("Testmanie");
        produitDto.setDescription("Test moi");
        produitDto.setCheminImage("C:/temp/img/test.png");
        produitDto.setVersion("1");

        Mockito.when(this.iProduitDaoMock.findByReference(produitDto.getReference())).thenReturn(null);
        Mockito.when(this.iProduitDaoMock.create(Mockito.any(ProduitDo.class))).thenReturn(ProduitMapper.mapToDo(produitDto));
        final var produitDtoCree = produitServiceMock.creerProduit(produitDto);
        assertArrayEquals(boolArrayToTest, produitDtoCree.getServices());
        assertNotNull(produitDtoCree);
        assertEquals("TEST00000", produitDtoCree.getReference());

    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#creerProduit(presentation.produit.dto.ProduitDto)}.
     */
    @Test
    void testCreerProduitDejaEnBase() {
        final Boolean[] boolArrayToTest = {false, false, false, false, false, false, false, false, true};
        final var produitDto = new ProduitDto();
        produitDto.setIdProduitOriginal("99");
        produitDto.setNom("Test Edition");
        produitDto.setReference("TEST00000");
        produitDto.setPrixUnitaire("10.00");
        produitDto.setServices(boolArrayToTest);
        produitDto.setMiseEnVente("true");
        produitDto.setHebergement("Hotel Test");
        produitDto.setDestination("Testmanie");
        produitDto.setDescription("Test moi");
        produitDto.setCheminImage("C:/temp/img/test.png");
        produitDto.setVersion("1");

        Mockito.when(this.iProduitDaoMock.findByReference(produitDto.getReference())).thenReturn(Mockito.notNull());
        final var produitDtoCree = produitServiceMock.creerProduit(produitDto);
        assertNull(produitDtoCree);

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
        // On récupère un produit en vente
        assertNotNull(produitServiceMock.trouverProduitEnVente(1));
        // On essaie de récupérer un produit qui n'est pas en vente
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
        produitDo.setDescription("Test super voyage à la découverte de zanzibar");
        produitDo.setCheminImage("C:/YNH/img");
        produitDo.setVersion(1);
        produitDo.setServices(1);
        Mockito.when(this.iProduitDaoMock.rechercherAllProduits("TEST")).thenReturn(List.of(produitDo));
        Mockito.when(this.iProduitDaoMock.rechercherAllProduits("ZZZ")).thenReturn(Collections.emptyList());
        // On récupère un produit en vente
        assertEquals(1, produitServiceMock.rechercherAllProduits("TEST").size());
        // On essaie de récupérer un produit qui n'existe pas
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
        //création des produits
        final var produitDo = new ProduitDo();
        produitDo.setPrixUnitaire(1274d);
        produitDo.setIdProduitOriginal(10);
        final var produitDo2 = new ProduitDo();
        produitDo2.setPrixUnitaire(126d);
        produitDo2.setIdProduitOriginal(11);
        final var produitDto = new ProduitDto();
        produitDto.setPrixUnitaire("1274,00");
        produitDto.setIdProduitOriginal("10");
        final var produitDto2 = new ProduitDto();
        produitDto2.setPrixUnitaire("126,00");
        produitDto2.setIdProduitOriginal("11");
        //création de la liste à retourner
        final List<ProduitDo> listeTriee = List.of(produitDo2, produitDo);
        Mockito.when(this.iProduitDaoMock.trierListe(TypeTriAlphanumerique.DESC)).thenReturn(listeTriee);
        //attribution des listes de produitDto, une triée, et une non triée qui sera triée par une méthode java
        final List<ProduitDto> liste = produitServiceMock.findFilter("", TypeTriAlphanumerique.findValue("2"));
        final List<ProduitDto> listeNonTriee = new ArrayList<>();
        listeNonTriee.addAll(List.of(produitDto, produitDto2));
        //création d'un comparator pour préparer le tri via java
        final Comparator<ProduitDto> produitDoPrixComparator = Comparator.comparing(ProduitDto::getPrixUnitaire);
        Collections.sort(listeNonTriee, produitDoPrixComparator);
        assertEquals(liste, listeNonTriee);
    }

    /**
     * Test method for {@link final service.produit.impl.ProduitService#trouverParReference(String)}.
     */

    @Test
    void testTrouverParReference() {
        final var produitDo = new ProduitDo();
        produitDo.setPrixUnitaire(125d);
        produitDo.setMiseEnVente(true);
        Mockito.when(this.iProduitDaoMock.findByReference("ITA1289967")).thenReturn(produitDo);
        Mockito.when(this.iProduitDaoMock.findByReference("REFERENCE_FAUSSE")).thenReturn(null);
        // On récupére un produit avec une référence existante
        assertNotNull(produitServiceMock.trouverParReference("ITA1289967"));
        // On récupére un produit avec une référence inexistante
        assertNull(produitServiceMock.trouverParReference("REFERENCE_FAUSSE"));
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#editerProduit(java.lang.Integer)}.
     */
    @Test
    void testEditerProduit() {
        final ProduitDto produitDto = new ProduitDto();
        final Boolean[] boolArrayToTest = {false, false, false, false, false, false, false, false, true};
        produitDto.setIdProduitOriginal("99");
        produitDto.setNom("Test Edition");
        produitDto.setReference("TEST00000");
        produitDto.setPrixUnitaire("10.00");
        produitDto.setServices(boolArrayToTest);
        produitDto.setMiseEnVente("true");
        produitDto.setHebergement("Hotel Test");
        produitDto.setDestination("Testmanie");
        produitDto.setDescription("Test moi");
        produitDto.setCheminImage("C:/temp/img/test.png");
        produitDto.setVersion("1");
        Mockito.when(this.iProduitDaoMock.findById(99)).thenReturn(ProduitMapper.mapToDo(produitDto));
        Mockito.when(this.iProduitDaoMock.update(Mockito.any(ProduitDo.class))).thenReturn(ProduitMapper.mapToDo(produitDto));
        assertNotNull(this.produitServiceMock.editerProduit(produitDto));
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#trouverProduitById(Integer)}.
     */
    @Test
    void testTrouverProduitByid() {
        final var produitDo = new ProduitDo();
        produitDo.setPrixUnitaire(125d);
        produitDo.setMiseEnVente(true);
        produitDo.setIdProduitOriginal(50);
        Mockito.when(this.iProduitDaoMock.findById(50)).thenReturn(produitDo);
        Mockito.when(this.iProduitDaoMock.findById(404)).thenReturn(null);
        // On récupére un produit avec un ID existant
        assertNotNull(produitServiceMock.trouverProduitById(50));
        // On récupére un produit avec un ID inexistant
        assertNull(produitServiceMock.trouverProduitById(404));
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#deleteProduit(ProduitDto)}.
     */
    @Test
    void testDeleteProduitOK() {
        final var produitDo = new ProduitDo();
        produitDo.setIdProduitOriginal(99);
        //On trouve le produit d'id 99
        Mockito.when(this.iProduitDaoMock.findById(99)).thenReturn(produitDo);
        assertTrue(produitServiceMock.deleteProduit(produitDo.getIdProduitOriginal()));
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#deleteProduit(ProduitDto)}.
     */
    @Test
    void testDeleteProduitKO() {
        final var produitDo = new ProduitDo();
        produitDo.setIdProduitOriginal(99);
        //On ne trouve pas le produit d'id 99
        Mockito.when(this.iProduitDaoMock.findById(99)).thenReturn(null);
        assertFalse(produitServiceMock.deleteProduit(produitDo.getIdProduitOriginal()));
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#updatePanier(PanierDto, BeanQuantite)}.
     */
    @Test
    void testUpdatePanierInvalideNegatif() {
        final PanierDto panier = new PanierDto();
        final BeanQuantite beanQuantite = new BeanQuantite();
        beanQuantite.setId("1");
        beanQuantite.setQuantite("-100");
        assertNull(produitServiceMock.updatePanier(panier, beanQuantite));
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#updatePanier(PanierDto, BeanQuantite)}.
     */
    @Test
    void testUpdatePanierInvalideTropGrand() {
        final PanierDto panier = new PanierDto();
        final BeanQuantite beanQuantite = new BeanQuantite();
        beanQuantite.setId("1");
        beanQuantite.setQuantite("200");
        assertNull(produitServiceMock.updatePanier(panier, beanQuantite));
    }

    /**
     * Test method for {@link service.produit.impl.ProduitService#updatePanier(PanierDto, BeanQuantite)}.
     */
    @Test
    void testUpdatePanierValide() {
        final PanierDto panier = new PanierDto();
        final PanierDto panierUpdated = new PanierDto();
        final BeanQuantite beanQuantite = new BeanQuantite();
        beanQuantite.setId("1");
        beanQuantite.setQuantite("94");
        panierUpdated.setPrixApresRemiseAffichage("1000");
        panierUpdated.setPrixTotalAffichage("1000");
        panierUpdated.setRemiseAffichage("0");
        Mockito.when(this.iPanierService.updatePanier(panier, 1, 94)).thenReturn(panierUpdated);
        assertNotNull(produitServiceMock.updatePanier(panier, beanQuantite));
    }

    /**
     * Test method for
     * {@link service.produit.impl.ProduitService#choixConsulterProduit(service.utilisateur.util.UtilisateurRoleEnum, Integer)}.
     */
    @Test
    void testChoixConsulterProduit() {

        final var produitDo = new ProduitDo();
        produitDo.setIdProduitOriginal(99);
        produitDo.setNom("Test en Tanzanie");
        produitDo.setReference("TEST556789");
        produitDo.setHebergement("Test BouiBoui and Co.");
        produitDo.setDestination("Test Zanzibar");
        produitDo.setPrixUnitaire(125d);
        produitDo.setMiseEnVente(true);
        produitDo.setDescription("Test super voyage à la découverte de zanzibar");
        produitDo.setCheminImage("C:/YNH/img");
        produitDo.setVersion(1);
        produitDo.setServices(1);

        Mockito.when(iProduitDaoMock.findById(1)).thenReturn(produitDo);
        Mockito.when(iProduitDaoMock.findProduitEnVente(1)).thenReturn(null);

        assertNotNull(produitServiceMock.consulterProduitWithRole(UtilisateurRoleEnum.ADMINISTRATEUR, 1));
        assertNull(produitServiceMock.consulterProduitWithRole(UtilisateurRoleEnum.VISITEUR, 1));
        assertNull(produitServiceMock.consulterProduitWithRole(UtilisateurRoleEnum.CLIENT, 1));
    }

    /**
     * Test method for
     * {@link service.produit.impl.ProduitService#filtrerEnVente(String, presentation.produit.controller.TypeFiltre)}.
     */
    @Test
    void testFilterEnVente() {
        final var produitDo = new ProduitDo();
        produitDo.setPrixUnitaire(1274d);
        produitDo.setIdProduitOriginal(10);
        produitDo.setReference("ZZZ1234567");
        produitDo.setMiseEnVente(true);
        final var produitDo2 = new ProduitDo();
        produitDo2.setPrixUnitaire(126d);
        produitDo2.setIdProduitOriginal(11);
        produitDo2.setReference("ZZZ9876543");
        produitDo.setMiseEnVente(false);
        final List<ProduitDo> liste = List.of(produitDo, produitDo2);
        Mockito.when(iProduitDaoMock.trouverProduitsRechercheFiltre("", null)).thenReturn(liste);
        Mockito.when(iProduitDaoMock.trouverProduitsRechercheFiltre("", TypeFiltre.ENVENTE)).thenReturn(List.of(produitDo));
        Mockito.when(iProduitDaoMock.trouverProduitsRechercheFiltre("ZZZ", null)).thenReturn(liste);
        Mockito.when(iProduitDaoMock.trouverProduitsRechercheFiltre("ZZZ", TypeFiltre.ENVENTE)).thenReturn(List.of(produitDo));
        //searchterm blank et tri null
        assertEquals(2, iProduitDaoMock.trouverProduitsRechercheFiltre("", null).size());
        //searchterm est blank et tri en vente
        assertEquals(1, iProduitDaoMock.trouverProduitsRechercheFiltre("", TypeFiltre.ENVENTE).size());
        //searchterm non vide et tri null
        assertEquals(2, iProduitDaoMock.trouverProduitsRechercheFiltre("ZZZ", null).size());
        //searchterm non vide et tri en vente
        assertEquals(1, iProduitDaoMock.trouverProduitsRechercheFiltre("ZZZ", TypeFiltre.ENVENTE).size());
    }
}
