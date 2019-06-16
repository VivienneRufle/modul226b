package viewController;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;


public class PlayerAmountViewController {

	ObservableList<Integer> selectionPlayerNumberList = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	ObservableList<Integer> selectionRoundsNumberList = FXCollections.observableArrayList(5, 10, 15, 20, 25, 30, 35, 40, 45, 50);
	
	@FXML
	private ChoiceBox selectionPlayerNumber;
	
	private void initializePlayerNumber() {
		selectionPlayerNumber.setValue("1");
		selectionPlayerNumber.setItems(selectionPlayerNumberList);
	}
	
	
	private ChoiceBox selectionRoundsNumber;
	
	private void initializeRoundsNumber() {
		selectionRoundsNumber.setValue("5");
		selectionRoundsNumber.setItems(selectionRoundsNumberList);
	}
	
	public int[] show() {
		return null;
	}

}
