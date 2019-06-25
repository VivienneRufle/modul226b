package viewController;

import heredity.GameCategoryController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RiskViewController implements GameCategoryController {
	
	@FXML
	private Button buttonRAufgabe;
	@FXML
	private Button buttonRNo;
	
	public int show(String playerName) {
		((Stage) buttonRAufgabe.getScene().getWindow()).showAndWait();
		return 0;
	}
	
	public void task() {
		((Stage) buttonRAufgabe.getScene().getWindow()).close();
	}
	
	public void noTask() {
		((Stage) buttonRAufgabe.getScene().getWindow()).close();
	}

}
