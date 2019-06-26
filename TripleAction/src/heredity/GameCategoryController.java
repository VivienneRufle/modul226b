package heredity;

/**
 * Definiert Vorgaben für einen AktionsviewController
 * 
 * @author Alexander Stammherr
 * @version 1.0
 *
 */
public interface GameCategoryController {
	/**
	 * Zeigt die View.
	 * 
	 * @param playerName Name des Spielers, der an der Reihe ist
	 * @return Anzahl Punkte
	 */
	public int show(String playerName);
}
