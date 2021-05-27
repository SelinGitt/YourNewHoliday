/**
 * 
 */
package presentation.util.gestionImg;

/**
 * Enum d'Extension
 *
 * @author Lucas Date : 22 avr. 2021
 */
public enum Extensions {
	/**
	 * constructeur png
	 */
	PNG("png"),
	/**
	 * constructeur jpg
	 */
	JPG("jpg"),
	/**
	 * constructeur jpeg
	 */
	JPEG("jpeg"),
	/**
	 * constructeur bmp
	 */
	BMP("bmp");

	private final String extension;

	private Extensions(final String extension) {
		this.extension = extension;
	}

	/**
	 * Getter for extension
	 *
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * Permet de tester si l'extension fait partie de l'enum
	 *
	 * @param  extension l'extension
	 * @return           <code>true</code> si l'extension correspond<br>
	 *                   <code>false</code> dans le cas contraire
	 */
	public static boolean isIn(final String extension) {
		for (int i = 0; i < Extensions.values().length; i++) {
			if (extension == Extensions.values()[i].getExtension()) {
				return true;
			}
		}
		return false;
	}

}
