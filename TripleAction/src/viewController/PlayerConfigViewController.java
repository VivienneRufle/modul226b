package viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PlayerConfigViewController {
	
	@FXML
	private Button buttonGameStart;

	
	public String[] show(int playerAmount) {
		String playersName [] = {
				null
		};	
		
		return playersName;
	}
	
	public void gameStart() {
		((Stage) buttonGameStart.getScene().getWindow()).close();
	}

}
