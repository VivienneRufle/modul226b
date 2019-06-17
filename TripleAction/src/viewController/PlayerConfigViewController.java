package viewController;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;

import javafx.fxml.FXML;

public class PlayerConfigViewController {

	PlayerAmountViewController pc = new PlayerAmountViewController();
	
	int x[] = pc.show();
	int playerNumber = x[0];
	
	@FXML
	private TextField namePlayer1 = new TextField();
	private TextField namePlayer2 = new TextField();
	private TextField namePlayer3 = new TextField();
	private TextField namePlayer4 = new TextField();
	private TextField namePlayer5 = new TextField();
	private TextField namePlayer6 = new TextField();
	private TextField namePlayer7 = new TextField();
	private TextField namePlayer8 = new TextField();
	private TextField namePlayer9 = new TextField();
	private TextField namePlayer10 = new TextField();
	private Button buttonGameStart  = new Button();
	
	private TextField[] fields = {namePlayer1, namePlayer2, namePlayer3, namePlayer4,
			namePlayer5, namePlayer6, namePlayer7, namePlayer8, namePlayer9, namePlayer10};

	
	public void textfieldActivator() {
		for (int i = 0; i <= playerNumber; i++) {
			fields[i].setText("Spieler Name");
			fields[i].setVisible(true);
		}
		
		for (int i = 10; i > playerNumber; i--) {
			fields[i].setText("Keine Weiteren Spieler");
			fields[i].setVisible(false);
		}
	}
	
	public void actionPerformed (ActionEvent e){
		if(e.getSource() == this.buttonGameStart){
            int auswahl = 0;
        }
	}

	
	public String[] show(int playerAmount) {
		String playersName [] = {
				namePlayer1.getName(), namePlayer2.getName(), namePlayer3.getName(),
				namePlayer4.getName(), namePlayer5.getName(), namePlayer6.getName(),
				namePlayer7.getName(), namePlayer8.getName(), namePlayer9.getName(),
				namePlayer10.getName()
		};	
		
		return playersName;
	}

}
