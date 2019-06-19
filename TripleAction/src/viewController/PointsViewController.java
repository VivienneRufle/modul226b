package viewController;

import java.util.ArrayList;

import application.Player;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class PointsViewController {
	
	@FXML
	private Button bPlay;
	@FXML
	private TableView<Player> points;
	@FXML
	private TableColumn<Player, String> pointsPlayer, pointsPoints;
	
	public void initialize() {
		pointsPlayer.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
		pointsPoints.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getPoints())));
	}

	public boolean show(ArrayList<Player> players) {
		points.setItems(FXCollections.observableArrayList(players));
		((Stage) bPlay.getScene().getWindow()).showAndWait();
		return false;
	}
	
	public void play() {
		((Stage) bPlay.getScene().getWindow()).close();
	}

}
