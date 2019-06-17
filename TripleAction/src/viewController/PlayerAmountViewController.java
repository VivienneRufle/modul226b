package viewController;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;


public class PlayerAmountViewController {
	
	PlayerConfigViewController pc = new PlayerConfigViewController();

	@FXML
	private ChoiceBox <Integer> selectionPlayerNumber = new ChoiceBox <Integer> 
	(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
	
	private ChoiceBox <Integer> selectionRoundsNumber = new ChoiceBox <Integer> 
	(FXCollections.observableArrayList(5, 10, 15, 20, 25, 30, 35, 40, 45, 50));
	
	public int[] show() {
		pc.textfieldActivator();
		int x [] = {selectionPlayerNumber.getValue(), selectionRoundsNumber.getValue()};
		return x;
	}
	
}
