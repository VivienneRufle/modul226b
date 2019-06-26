package viewController;

import heredity.DareTruthController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * Controller für die Anzeige einer Wahrheit-View
 * @author Vivienne Rufle
 * @version 1.1
 *
 */
public class TruthViewController extends DareTruthController {
	
	@FXML
	private Button buttonTAufgabe1;
	@FXML
	private Button buttonTAufgabe2;
	@FXML
	private Button buttonTAufgabe3;
	@FXML
	private Text textCaption;
	
	/**
	 * Initialisiert das GUI gemäss der Oberklasse
	 */
	public void initialize() {
		super.setVariables(true, buttonTAufgabe1, buttonTAufgabe2, buttonTAufgabe3, textCaption);
	}
}
