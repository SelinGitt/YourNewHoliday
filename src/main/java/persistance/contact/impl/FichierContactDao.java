/**
 * 
 */
package persistance.contact.impl;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import persistance.contact.IFichierContactDao;

/**
 * Classe représentant le dao de fichierContactDao
 *
 * @author Alexandre
 */
@Repository
public class FichierContactDao implements IFichierContactDao {

    @Override
    public String trouverFichierContact(final String nomFichier) {
        String contenuHtml = "";
        //creation d'un FileReader avec le nom du fichier
        final File file = new File(nomFichier);
        try (final Scanner scanner = new Scanner(file)) {
            //passe le contenu du fichier html dans la string contenuHtml
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                contenuHtml += line;
            }
        } catch (final IOException exception) {
            //si exception
            exception.printStackTrace();
        }
        return contenuHtml;
    }
}
