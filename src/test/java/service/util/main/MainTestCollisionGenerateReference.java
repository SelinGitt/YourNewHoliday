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
     * Permet d'entrer du test
     *
     * @param args pas d'argument attendu
     */
    public static void main(final String[] args) {
        final var referenceCommande = new GenerateReferenceCommandeUtil();
        final int commandeCollision = compterCollisions(referenceCommande);
        final var referenceProduit = new GenerateReferenceProduitUtil();
        referenceProduit.constructPrefix("Italie");
        final int produitCollision = compterCollisions(referenceProduit);
        final var referenceUtilisateur = new GenerateReferenceUtilisateurUtil();
        final int utilisateurCollision = compterCollisions(referenceUtilisateur);
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
    private static int compterCollisions(final IGenerateReferenceUtil iGenerateReferenceUtil) {
        final Set<String> referenceGenerer = new HashSet<>();
        int comptage = 0;
        for (int i = 0; i < NB_ITERATION; i++) {
            final String reference = iGenerateReferenceUtil.generateRef();
            if (referenceGenerer.contains(reference)) {
                comptage++;
            } else {
                referenceGenerer.add(reference);
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
