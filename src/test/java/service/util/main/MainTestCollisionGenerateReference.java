/**
 * 
 */
package service.util.main;

import java.util.HashSet;
import java.util.Set;

import service.util.IGenerateReferenceUtil;
import service.util.impl.GenerateReferenceCommandeUtil;
import service.util.impl.GenerateReferenceProduitUtil;
import service.util.impl.GenerateReferenceUtilisateurUtil;

/**
 * Classe représentant le comptage sur 100 000 itérations du nombres de collisions des générateurs
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
public class MainTestCollisionGenerateReference {

    private static final int NB_ITERATION = 100000;

    /**
     * Point d'entrer du test
     *
     * @param args pas d'argument attendu
     */
    public static void main(final String[] args) {
        // référence générer pour commande
        final IGenerateReferenceUtil referenceCommande = new GenerateReferenceCommandeUtil();
        final int commandeCollision = genererReferenceRetourneNombreCollisions(referenceCommande);

        // référence générer pour produit
        final IGenerateReferenceUtil referenceProduit = new GenerateReferenceProduitUtil();
        // construit le préfixe pour produit (les 3 premières lettres en majscule de la destination)
        referenceProduit.constructPrefix("Italie");
        final int produitCollision = genererReferenceRetourneNombreCollisions(referenceProduit);

        // référence pour utilisateur
        final IGenerateReferenceUtil referenceUtilisateur = new GenerateReferenceUtilisateurUtil();
        final int utilisateurCollision = genererReferenceRetourneNombreCollisions(referenceUtilisateur);

        // affichage du nombre de collision
        printNbCollision("commande", commandeCollision);
        printNbCollision("produit", produitCollision);
        printNbCollision("utilisateur", utilisateurCollision);
    }

    /**
     * Permet de compter les références semblables pour un générateur sur 100 000 itérations
     *
     * @param  iGenerateReferenceUtil le générateur à tester
     * @return                        int le nobmre de collisions
     */
    private static int genererReferenceRetourneNombreCollisions(final IGenerateReferenceUtil iGenerateReferenceUtil) {
        final Set<String> referenceGenerer = new HashSet<>();
        int comptage = 0;
        for (int i = 0; i < NB_ITERATION; i++) {
            final String reference = iGenerateReferenceUtil.generateReference();
            if (!referenceGenerer.add(reference)) {
                comptage++;
            }
        }
        return comptage;
    }

    /**
     * Permet de d'afficher le nombre de collision pour une feature
     *
     * @param nameReference   le nom de la feature
     * @param numberCollision le nombre de collision calculer
     */
    private static void printNbCollision(final String nameReference, final int numberCollision) {
        System.out.println("Nombre de collisions pour " + nameReference + " : " + numberCollision + " / " + NB_ITERATION);
    }

}
