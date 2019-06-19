package viewController;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;


public class PlayerAmountViewController {

	@FXML
	private ChoiceBox <Integer> selectionPlayerNumber;
	@FXML
	private ChoiceBox <Integer> selectionRoundsNumber;
	
	public int[] show() {
		selectionPlayerNumber.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		selectionRoundsNumber.setItems(FXCollections.observableArrayList(5, 10, 15, 20, 25, 30, 35, 40, 45, 50));
		
		((Stage) selectionPlayerNumber.getScene().getWindow()).showAndWait();
		((Stage) selectionPlayerNumber.getScene().getWindow()).setTitle("Test");
		int x [] = {selectionPlayerNumber.getValue(), selectionRoundsNumber.getValue()};
		return x;
	}
	
}
