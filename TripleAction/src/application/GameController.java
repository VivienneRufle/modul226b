package application;

import java.util.ArrayList;

import heredity.GameCategoryController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import viewController.PlayerAmountViewController;
import viewController.PlayerConfigViewController;
import viewController.PointsViewController;
import viewController.SelectionViewController;

public class GameController {

	private Stage stage;

	public GameController(Stage stage) {
		this.stage = stage;
	}

	public void play() {

		boolean newGame;
		
		do {

			int[] amount;
			ArrayList<Player> players = new ArrayList<Player>();
			String[] playerNames;

			try {
				Stage stage = new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PlayerAmountView.fxml"));
				Parent root = loader.load();

				PlayerAmountViewController controller = loader.getController();

				Scene scene = new Scene(root);
				stage.setScene(scene);
				amount = controller.show();

			} catch (Exception e) {
				ShowError("Startfehler",
						"Scheint als wäre beim Starten des Programms ein Fehler aufgetreten :(\nBitte starte es neu.",
						e);
				return;
			}

			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PlayerConfigView.fxml"));
				Parent root = loader.load();

				PlayerConfigViewController controller = loader.getController();

				Scene scene = new Scene(root);
				stage.setScene(scene);
				playerNames = controller.show(amount[0]);

				for (String name : playerNames) {
					players.add(new Player(name));
				}
			} catch (Exception e) {
				 //ShowError();
				return;
			}

			for (int i = 0; i < amount[1]; i++) {

				for (Player player : players) {
					int selection;

					try {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SelectionView.fxml"));
						Parent root = loader.load();

						SelectionViewController controller = loader.getController();

						Scene scene = new Scene(root);
						stage.setScene(scene);
						selection = controller.show(player.getName());

					} catch (Exception e) {
						 //ShowError();
						return;
					}

					int points = 0;

					try {

						FXMLLoader loader = null;
						GameCategoryController controller;

						switch (selection) {
						case 0:
							loader = new FXMLLoader(getClass().getResource("/view/DareView.fxml"));
							break;
						case 1:
							loader = new FXMLLoader(getClass().getResource("/view/TruthView.fxml"));
							break;
						case 2:
							loader = new FXMLLoader(getClass().getResource("/view/RiskView.fxml"));
							break;
						}

						controller = loader.getController();

						Parent root = loader.load();

						Scene scene = new Scene(root);
						stage.setScene(scene);
						points = controller.show(player.getName());

					} catch (Exception e) {
						// ShowError();
						return;
					}

					player.addPoints(points);
				}
			}
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PointsView.fxml"));
				Parent root = loader.load();

				PointsViewController controller = loader.getController();

				Scene scene = new Scene(root);
				stage.setScene(scene);
				newGame = controller.show(players);

			} catch (Exception e) {
				 //ShowError();
				return;
			}

		} while (newGame);
	}

	private void ShowError(String title, String message) {

	}

	private void ShowError(String title, String message, Exception e) {
		e.printStackTrace();
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);

		alert.showAndWait();
		return;
	}
}
