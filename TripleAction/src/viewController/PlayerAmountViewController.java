package viewController;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;


public class PlayerAmountViewController {

	@FXML
	private ChoiceBox <Integer> selectionPlayerNumber;
	@FXML
	private ChoiceBox <Integer> selectionRoundsNumber;
	@FXML
	private Button bNext;
	
	private int playerNumber = 0;
	private int roundsNumber = 0;
	
	public int[] show() {
		selectionPlayerNumber.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		selectionPlayerNumber.getSelectionModel().select(0);
		selectionRoundsNumber.setItems(FXCollections.observableArrayList(5, 10, 15, 20, 25, 30, 35, 40, 45, 50));
		selectionRoundsNumber.getSelectionModel().select(0);
		
		((Stage) selectionPlayerNumber.getScene().getWindow()).showAndWait();
		int x [] = {playerNumber, roundsNumber};
		return x;
	}
	
	public void next() {
		playerNumber = selectionPlayerNumber.getValue();
		roundsNumber = selectionRoundsNumber.getValue();
		((Stage) selectionPlayerNumber.getScene().getWindow()).close();
	}
}
