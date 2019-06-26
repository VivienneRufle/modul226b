package viewController;

import java.util.ArrayList;

import application.Player;
import application.PlayerListCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * Controller für das Konfigurationsfenster der Spieler
 * 
 * @author Vivienne Rufle
 * @version 1.0
 *
 */
public class PlayerConfigViewController {

	@FXML
	private Button buttonGameStart;
	@FXML
	private ListView<Player> playersName;

	private ObservableList<Player> list;
	ArrayList<Player> players = null;

	/**
	 * Initialisiert das GUI und legt Daten fest
	 */
	public void initialize() {
		list = FXCollections.observableArrayList();
		playersName.setItems(list);

		playersName.setEditable(true);
		playersName.setCellFactory(lv -> new PlayerListCell());
	}

	/**
	 * Zeigt die View. Geniert aufgrund der angegebenen Anzahl Spieler entsprechende
	 * PlayerObjekte und gibt diese zurück
	 * 
	 * @param playerAmount Die Anzahl der Spieler die generiert werden soll
	 * @return ArryList mit allen Playerobjekte
	 */
	public ArrayList<Player> show(int playerAmount) {

		for (int i = 1; i <= playerAmount; i++) {
			String name = "Spieler " + i;
			list.add(new Player(name));
		}

		((Stage) buttonGameStart.getScene().getWindow()).showAndWait();

		return players;
	}

	public void gameStart() {
		players = new ArrayList<Player>(list);
		((Stage) buttonGameStart.getScene().getWindow()).close();
	}

}
