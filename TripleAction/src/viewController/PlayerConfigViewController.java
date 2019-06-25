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

public class PlayerConfigViewController {
	
	@FXML
	private Button buttonGameStart;
	@FXML
	private ListView<Player> playersName;
	
	private ObservableList<Player> list;
	ArrayList<Player> players = null;
	
	public void initialize() {
		list = FXCollections.observableArrayList();
		playersName.setItems(list);
		
		playersName.setEditable(true);
		playersName.setCellFactory(lv -> new PlayerListCell());
	}
	
	public ArrayList<Player> show(int playerAmount) {
		
		for(int i = 1; i <= playerAmount; i++) {
			String name = "Spieler "+i;
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
