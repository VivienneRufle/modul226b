package viewController;

import application.Player;
import application.PlayerListCell;
import javafx.application.Platform;
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
	
	public void initialize() {
		list = FXCollections.observableArrayList();
		playersName.setItems(list);
		
		playersName.setEditable(true);
		playersName.setCellFactory(lv -> new PlayerListCell());
	}
	
	public Player[] show(int playerAmount) {
		
		for(int i = 1; i <= playerAmount; i++) {
			String name = "Spieler "+i;
			list.add(new Player(name));
		}
		
		((Stage) buttonGameStart.getScene().getWindow()).showAndWait();
		Player[] players = (Player[]) list.toArray();
		
		return players;
	}
	
	public void gameStart() {
		((Stage) buttonGameStart.getScene().getWindow()).close();
	}

}
