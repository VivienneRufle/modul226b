package viewController;

import heredity.DareTruthController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * Controller für eine View welche 3 Tat-View
 * @author Vivienne Controller
 * @version 1.1
 * @see DareTruthController
 */
public class DareViewController extends DareTruthController {

	@FXML
	private Button buttonDAufgabe1;
	@FXML
	private Button buttonDAufgabe2;
	@FXML
	private Button buttonDAufgabe3;
	@FXML
	private Text textCaption;
	
	/**
	 * Initialisiert das GUI gemäss der Oberklasse
	 */
	public void initialize() {
		super.setVariables(false, buttonDAufgabe1, buttonDAufgabe2, buttonDAufgabe3, textCaption);
	}
	
}
