package viewController;

import heredity.DareTruthController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DareViewController extends DareTruthController {
	
	@FXML
	private Button buttonDAufgabe1;
	@FXML
	private Button buttonDAufgabe2;
	@FXML
	private Button buttonDAufgabe3;
	@FXML
	private Button buttonDNo;
	
	public void task() {
		((Stage) buttonDAufgabe1.getScene().getWindow()).close();
	}
	
	public void notask() {
		((Stage) buttonDAufgabe1.getScene().getWindow()).close();
	}
	
}
