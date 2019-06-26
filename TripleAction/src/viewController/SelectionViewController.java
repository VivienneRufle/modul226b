package viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Controller für die Auswahl-View
 * 
 * @author Vivienne Rufle
 * @version 1.0
 *
 */
public class SelectionViewController {

	int auswahl = -1;

	@FXML
	private Button buttonDare;
	@FXML
	private Button buttonTruth;
	@FXML
	private Button buttonRisk;
	@FXML
	private Text textCaption;

	/**
	 * Zeigt die View und legt die Anzeigeelemente fest
	 * 
	 * @param playerName Name des Spielers der an der Reihe ist
	 * @return Die getätigte Auswahl
	 */
	public int show(String playerName) {
		textCaption.setText(playerName + " hat die Wahl:");
		((Stage) buttonDare.getScene().getWindow()).showAndWait();
		return auswahl;
	}

	/**
	 * Methode wenn Tat geklickt wurde. Ruft die Close-Methode mit der Auswahlnummer
	 * auf.
	 */
	public void dare() {
		close(0);
	}

	/**
	 * Methode wenn Wahrheit geklickt wurde. Ruft die Close-Methode mit der
	 * Auswahlnummer auf.
	 */
	public void truth() {
		close(1);
	}

	/**
	 * Methode wenn Risiko geklickt wurde. Ruft die Close-Methode mit der
	 * Auswahlnummer auf.
	 */
	public void risk() {
		close(2);
	}

	/**
	 * Schliesst die View und legt die Nummer der Auswahl fest
	 * 
	 * @param a Nummer der Auswahl
	 */
	public void close(int a) {
		auswahl = a;
		((Stage) buttonDare.getScene().getWindow()).close();
	}

}
