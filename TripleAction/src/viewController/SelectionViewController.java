package viewController;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.fxml.FXML;

public class SelectionViewController implements ActionListener{

	int auswahl = 5;
	
	@FXML
	private Button buttonDare = new Button();
	private Button buttonTruth = new Button();
	private Button buttonRisk = new Button();
	
	public void actionPerformed (ActionEvent e){
		if(e.getSource() == this.buttonDare){
            auswahl = 0;
        }
        else if(e.getSource() == this.buttonTruth){
            auswahl = 1;
        }
        else if (e.getSource() == this.buttonRisk){
        	auswahl = 2;
        }
	}
	
	
	public int show(String name) {
		return auswahl;
	}

}
