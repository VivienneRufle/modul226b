package application;

/**
 * Stellt ein Spieler dar
 * 
 * @author Alexander Stammherr
 * @version 1.0
 *
 */
public class Player {

	private String name;
	private int points = 0;

	/**
	 * Erstellt den Spieler und definiert seinen Namen.
	 * 
	 * @param name Namen des Spielers
	 */
	public Player(String name) {
		this.name = name;
	}

	/**
	 * Gibt den Namen des Spielers zur�ck
	 * 
	 * @return Den Namen des Spielers
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gibt die Anzahl Punkte zur�ck
	 * 
	 * @return Anzahl Punkte des Spielers
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * F�gt Punkte dem Spieler hinzu. Kann auch negativ sein
	 * 
	 * @param amount Anzahl Punkte die hinzugef�gt werden soll
	 */
	public void addPoints(int amount) {
		points += amount;
	}

	/**
	 * Setzt den Namen des Spielers
	 * 
	 * @param name Name der gesetzt werden soll
	 */
	public void setName(String name) {
		this.name = name;
	}
}
