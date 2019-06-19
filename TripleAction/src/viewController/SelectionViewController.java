package viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SelectionViewController{
	
	int auswahl = 5;
	
	@FXML
	private Button buttonDare;
	private Button buttonTruth;
	private Button buttonRisk;

	
	public int show(String name) {
		((Stage) buttonDare.getScene().getWindow()).showAndWait();
		return auswahl;
	}
	
	public void dare() {
		((Stage) buttonDare.getScene().getWindow()).close();
		auswahl = 0;
	}
	
	public void truth() {
		((Stage) buttonDare.getScene().getWindow()).close();
		auswahl = 1;
	}
	
	public void risk() {
		((Stage) buttonDare.getScene().getWindow()).close();
		auswahl = 2;
	}

}
