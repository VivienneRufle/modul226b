package viewController;

import heredity.DareTruthController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class DareViewController extends DareTruthController {

	@FXML
	private Button buttonDAufgabe1;
	@FXML
	private Button buttonDAufgabe2;
	@FXML
	private Button buttonDAufgabe3;
	@FXML
	private Text textCaption;
	
	public void initialize() {
		super.setVariables(true, buttonDAufgabe1, buttonDAufgabe2, buttonDAufgabe3, textCaption);
	}
	
}
