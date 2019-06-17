package viewController;

import java.awt.Button;
import java.awt.event.ActionEvent;

import heredity.DareTruthController;
import javafx.fxml.FXML;

public class DareViewController extends DareTruthController {

	int auswahl = 5;
	
	@FXML
	private Button buttonDAufgabe1 = new Button();
	private Button buttonDAufgabe2 = new Button();
	private Button buttonDAufgabe3 = new Button();
	private Button buttonDNo = new Button();
	
	public int actionPerformed (ActionEvent e){
		if(e.getSource() == this.buttonDAufgabe1){
            auswahl = 0;
            return auswahl;
        }
        else if(e.getSource() == this.buttonDAufgabe2){
            auswahl = 0;
            return auswahl;
        }
        else if (e.getSource() == this.buttonDAufgabe3){
        	auswahl = 0;
        	return auswahl;
        }
        else if (e.getSource() == this.buttonDNo) {
        	auswahl = 1;
        	return auswahl;
        }
		return auswahl;
	}
	
	
}
