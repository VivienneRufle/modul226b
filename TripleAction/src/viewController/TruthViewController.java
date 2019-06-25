package viewController;

import java.awt.event.ActionEvent;

import heredity.DareTruthController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TruthViewController extends DareTruthController {

int auswahl = 5;
	
	@FXML
	private Button buttonTAufgabe1;
	@FXML
	private Button buttonTAufgabe2;
	@FXML
	private Button buttonTAufgabe3;
	@FXML
	private Button buttonTNo;
	
	public void task() {
		((Stage) buttonTAufgabe1.getScene().getWindow()).close();
	}
	
	public void notask() {
		((Stage) buttonTAufgabe1.getScene().getWindow()).close();
	}
}
