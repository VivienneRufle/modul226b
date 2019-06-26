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

/**
 * Controller für die Anzeige der Spieler und deren Punkte
 * 
 * @author Vivienne Rufle
 * @version 1.0
 *
 */
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

	/**
	 * Initialisiert die View und legt fest, wie die Player-Objekte in der Tabelle
	 * angezeigt werden sollen
	 */
	public void initialize() {
		pointsPlayer.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
		pointsPoints.setCellValueFactory(
				cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getPoints())));
	}

	/**
	 * Zeigt die View und legt die zu anzeigenden Daten fest
	 * 
	 * @param players Geordnete Liste der Spieler die angezeigt werden sollen.
	 *                Spieler sollen nach Punkte absteigend sortiert sein
	 * @return Ob nochmals gespielt werden soll
	 */
	public boolean show(List<Player> players) {

		textCaption.setText(players.get(0).getName() + " hat gewonnen");

		points.setItems(FXCollections.observableArrayList(players));
		((Stage) bPlay.getScene().getWindow()).showAndWait();
		return backBool;
	}

	/**
	 * Methode, wenn nochmals gespielt werden soll. Schlisst die View und aktiviert,
	 * dass eine neue Runde gespielt werden möchte.
	 */
	public void play() {
		backBool = true;
		((Stage) bPlay.getScene().getWindow()).close();
	}

}
