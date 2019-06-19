package viewController;

import java.util.ArrayList;

import application.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PointsViewController {
	
	@FXML
	private Button bPlay;

	public boolean show(ArrayList<Player> players) {
		((Stage) bPlay.getScene().getWindow()).showAndWait();
		return false;
	}
	
	public void play() {
		((Stage) bPlay.getScene().getWindow()).close();
	}

}
