/**
 * 
 */
package persistance.contact.impl;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import persistance.contact.IFichierContactDao;

/**
 * Classe représentant le dao de fichierContactDao
 *
 * @author Alexandre
 */
@Repository
public class FichierContactDao implements IFichierContactDao {

    static final Logger logger = LoggerFactory.getLogger(FichierContactDao.class);

    @Override
    public String trouverFichierContact(final String nomFichier) {
        final StringBuilder strBuilder = new StringBuilder();
        String contenuHtml = "";
        //creation d'un FileReader avec le nom du fichier
        final File file = new File(nomFichier);
        try (final Scanner scanner = new Scanner(file)) {
            //passe le contenu du fichier html dans la string contenuHtml
            while (scanner.hasNext()) {
                final String line = scanner.nextLine();
                strBuilder.append(line);
            }
        } catch (final IOException exception) {
            //si exception 
            String erreur = "IoEception Error" + exception.getMessage();
            logger.error(erreur);
        }
        contenuHtml = strBuilder.toString();
        return contenuHtml;
    }
}
