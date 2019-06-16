package viewController;

import java.awt.TextField;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class PlayerConfigViewController {
	
	@FXML
	private TextField namePlayer1;
	private TextField namePlayer2;
	private TextField namePlayer3;
	private TextField namePlayer4;
	private TextField namePlayer5;
	private TextField namePlayer6;
	private TextField namePlayer7;
	private TextField namePlayer8;
	private TextField namePlayer9;
	private TextField namePlayer10;

	public String[] show(int playerAmount) {
		
		ArrayList<String> playersName = new ArrayList<String>();
			playersName.add(namePlayer1.getName());
			playersName.add(namePlayer2.getName());
			playersName.add(namePlayer3.getName());
			playersName.add(namePlayer4.getName());
			playersName.add(namePlayer5.getName());
			playersName.add(namePlayer6.getName());
			playersName.add(namePlayer7.getName());
			playersName.add(namePlayer8.getName());
			playersName.add(namePlayer9.getName());
			playersName.add(namePlayer10.getName());		
		
		return null;
	}

}
