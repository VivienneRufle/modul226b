package viewController;

import java.awt.Button;
import java.awt.event.ActionEvent;

import heredity.DareTruthController;
import javafx.fxml.FXML;

public class DareViewController extends DareTruthController {

int auswahl = 5;
	
	@FXML
	private Button buttonDAufgabe1;
	private Button buttonDAufgabe2;
	private Button buttonDAufgabe3;
	private Button buttonDNo;
	
	public void actionPerformed (ActionEvent e){
		if(e.getSource() == this.buttonDAufgabe1){
            auswahl = 0;
        }
        else if(e.getSource() == this.buttonDAufgabe2){
            auswahl = 0;
        }
        else if (e.getSource() == this.buttonDAufgabe3){
        	auswahl = 0;
        }
        else if (e.getSource() == this.buttonDNo) {
        	auswahl = 1;
        }
	}
	
	
}
