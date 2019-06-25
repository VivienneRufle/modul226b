package viewController;

import heredity.DareTruthController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class TruthViewController extends DareTruthController {
	
	@FXML
	private Button buttonTAufgabe1;
	@FXML
	private Button buttonTAufgabe2;
	@FXML
	private Button buttonTAufgabe3;
	@FXML
	private Text textCaption;
	
	public void initialize() {
		super.setVariables(false, buttonTAufgabe1, buttonTAufgabe2, buttonTAufgabe3, textCaption);
	}
}
