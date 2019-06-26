package heredity;

import java.util.ArrayList;

import application.DataController;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Stellt eine Vorlage für einen AktionsController mit 3 Aktionen dar.
 * 
 * @author Alexander Stammherr
 * @version 1.0
 * @see GameCategoryController
 *
 */
public abstract class DareTruthController implements GameCategoryController {

	private int points = -1;

	boolean question;
	private Button one;
	private Button two;
	private Button three;
	private Text caption;

	/**
	 * Setzt die Variablen die sich je nach Controller unterscheiden
	 * 
	 * @param question Werden Fragen angezeigt?
	 * @param one      Erster Aktionsbutton
	 * @param two      Zweiter Aktionsbutton
	 * @param three    Dritter Aktionsbutton
	 * @param caption  Text welcher angezeigt wird
	 */
	public void setVariables(boolean question, Button one, Button two, Button three, Text caption) {
		this.question = question;
		this.one = one;
		this.two = two;
		this.three = three;
		this.caption = caption;
	}

	/**
	 * Zeigt View und füllt die Aktionstexte ein
	 * 
	 * @param playerName Name des Spielers der an der Reihe ist
	 */
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

	/**
	 * Eine Aktion wurde erfüllt. close-Methode mit passenden Punkte wird aufgerufen
	 * 
	 * @see DareTruthController#close(int)
	 */
	public void task() {
		if (question) {
			close(1);
		} else {
			close(2);
		}
	}

	/**
	 * Keine Aktion wurde erfüllt. close-Methode mit passenden Punkte wird aufgerufen
	 * @see DareTruthController#close(int)
	 */
	public void notask() {
		close(0);
	}
	
	/**
	 * Definiert die Anzahl Punkte und definiert die Anzahl Punkte
	 * @param p Anzahl Punkt
	 */
	private void close(int p) {
		points = p;
		((Stage) one.getScene().getWindow()).close();
	}
}
