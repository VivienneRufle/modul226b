package viewController;

import application.DataController;
import heredity.GameCategoryController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Controller für eine Risiko-View
 * 
 * @author Vivienne Rufle
 * @version 1.0
 * @see GameCategoryController
 */
public class RiskViewController implements GameCategoryController {

	@FXML
	private Button buttonRAufgabe;
	@FXML
	private Button buttonRNo;
	@FXML
	private Text textCaption;

	private int points = -1;

	/**
	 * View wird angezeigt und die Anzeigedaten festgelegt.
	 * 
	 * @param playerName Name des Spielers der an der Reihe ist
	 * @return Anzahl Punkte
	 */
	public int show(String playerName) {
		textCaption.setText(playerName + " muss folgende Aufgabe lösen:");

		String dare = DataController.INSTANCE.getTasks(false, 1).get(0);

		buttonRAufgabe.setText(dare);

		buttonRAufgabe.setTooltip(new Tooltip(dare));

		Stage stage = ((Stage) buttonRAufgabe.getScene().getWindow());

		stage.setTitle("TripleAction - Risiko");

		stage.showAndWait();
		return points;
	}

	/**
	 * Methode wenn die Aufgabe erfüllt wurde. Ruft die Close-Methode mit den
	 * passenden Punkte auf
	 */
	public void task() {
		close(4);
	}

	/**
	 * Methode wenn keine Aufgabe erfüllt wurde. Ruft die Close-Methode mit den
	 * passenden Punkte auf
	 */
	public void noTask() {
		close(0);
	}

	/**
	 * Schliesst die View und legt die Anzahl Punkte fest
	 * 
	 * @param p Anzahl Punkte
	 */
	private void close(int p) {
		points = p;
		((Stage) buttonRAufgabe.getScene().getWindow()).close();
	}

}
