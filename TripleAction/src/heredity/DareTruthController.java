package heredity;

import java.util.ArrayList;

import application.DataController;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class DareTruthController implements GameCategoryController {
	
	private int points = -1;
	
	boolean question;
	private Button one;
	private Button two;
	private Button three;
	private Text caption;
	
	public void setVariables(boolean question, Button one, Button two, Button three, Text caption) {
		this.question = question;
		this.one = one;
		this.two = two;
		this.three = three;
		this.caption = caption;
	}
	
	public int show(String playerName) {
		ArrayList<String> questions = DataController.INSTANCE.getTasks(question, 3);
		String singleQuestion = questions.get(0);
		one.setText(singleQuestion);
		one.setTooltip(new Tooltip(singleQuestion));
		singleQuestion = questions.get(1);
		two.setText(singleQuestion);
		two.setTooltip(new Tooltip(singleQuestion));
		singleQuestion = questions.get(2);
		three.setText(singleQuestion);
		three.setTooltip(new Tooltip(singleQuestion));
		caption.setText(playerName + " muss eine der folgenden Aufgaben lösen:");
		
		Stage stage = ((Stage) one.getScene().getWindow());
		
		if (question) {
			stage.setTitle("TripleAction - Wahrheit");
		} else {
			stage.setTitle("TripleAction - Tat");
		}
		
		stage.showAndWait();
		return points;
	}
	
	public void task() {
		if (question) {
			points = 1;
		} else {
			points = 2;
		}
		((Stage) one.getScene().getWindow()).close();
	}
	
	public void notask() {
		points = 0;
		((Stage) one.getScene().getWindow()).close();
	}
}
