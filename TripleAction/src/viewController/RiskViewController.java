package viewController;

import java.awt.Button;
import java.awt.event.ActionEvent;

import heredity.GameCategoryController;
import javafx.fxml.FXML;

public class RiskViewController implements GameCategoryController {

int auswahl = 5;
	
	@FXML
	private Button buttonRAufgabe;
	private Button buttonRNo;
	
	public void actionPerformed (ActionEvent e){
		if(e.getSource() == this.buttonRAufgabe){
        	auswahl = 0;
        }
        else if (e.getSource() == this.buttonRNo) {
        	auswahl = 1;
        }
	}
	
	public int show(String playerName) {
		// TODO Auto-generated method stub
		return 0;
	}

}
