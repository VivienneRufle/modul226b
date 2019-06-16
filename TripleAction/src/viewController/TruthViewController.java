package viewController;

import java.awt.Button;
import java.awt.event.ActionEvent;

import heredity.DareTruthController;
import javafx.fxml.FXML;

public class TruthViewController extends DareTruthController {

int auswahl = 5;
	
	@FXML
	private Button buttonTAufgabe1;
	private Button buttonTAufgabe2;
	private Button buttonTAufgabe3;
	private Button buttonTNo;
	
	public void actionPerformed (ActionEvent e){
		if(e.getSource() == this.buttonTAufgabe1){
            auswahl = 0;
        }
        else if(e.getSource() == this.buttonTAufgabe2){
            auswahl = 0;
        }
        else if (e.getSource() == this.buttonTAufgabe3){
        	auswahl = 0;
        }
        else if (e.getSource() == this.buttonTNo) {
        	auswahl = 1;
        }
	}
}
