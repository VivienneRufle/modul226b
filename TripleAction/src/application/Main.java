package application;
	
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Startet das Programm
 * 
 * @author Alexander Stammherr
 * @version 1.0
 *
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		GameController gameController = new GameController();
		gameController.play();
	}
	
	/**
	 * Ruft die Launch-Methode aus der Klasse Application auf
	 * 
	 * @param args Arbumente werden nicht verarbeitet
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
