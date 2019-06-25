package viewController;

import java.util.List;

import application.Player;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PointsViewController {
	
	@FXML
	private Button bPlay;
	@FXML
	private TableView<Player> points;
	@FXML
	private TableColumn<Player, String> pointsPlayer, pointsPoints;
	@FXML
	private Text textCaption;
	
	private boolean backBool = false;
	
	public void initialize() {
		pointsPlayer.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
		pointsPoints.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getPoints())));
	}

	public boolean show(List<Player> players) {
		
		textCaption.setText(players.get(0).getName() + " hat gewonnen");
		
		points.setItems(FXCollections.observableArrayList(players));
		((Stage) bPlay.getScene().getWindow()).showAndWait();
		return backBool;
	}
	
	public void play() {
		backBool = true;
		((Stage) bPlay.getScene().getWindow()).close();
	}

}
