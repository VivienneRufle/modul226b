package viewController;

import application.DataController;
import heredity.GameCategoryController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RiskViewController implements GameCategoryController {
	
	@FXML
	private Button buttonRAufgabe;
	@FXML
	private Button buttonRNo;
	@FXML
	private Text textCaption;
	
	private int points = -1;
	
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
	
	public void task() {
		points = 4;
		((Stage) buttonRAufgabe.getScene().getWindow()).close();
	}
	
	public void noTask() {
		points = 0;
		((Stage) buttonRAufgabe.getScene().getWindow()).close();
	}

}
