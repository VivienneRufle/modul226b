package viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SelectionViewController{
	
	int auswahl = -1;
	
	@FXML
	private Button buttonDare;
	@FXML
	private Button buttonTruth;
	@FXML
	private Button buttonRisk;
	@FXML
	private Text textCaption;

	
	public int show(String name) {
		textCaption.setText(name + " hat die Wahl:");
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
