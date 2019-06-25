package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
		// this.stage = stage;
	}

	public void play() {

		boolean newGame;

		do {

			int[] amount;
			ArrayList<Player> players;

			try {
				stage = new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PlayerAmountView.fxml"));
				Parent root = loader.load();

				PlayerAmountViewController controller = loader.getController();

				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setTitle("TripleAction - Grundkofiguration ");
				amount = controller.show();

				if (amount[0] == 0) {
					return;
				}

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
				stage.setTitle("TripleAction - Player konfigurieren");
				players = controller.show(amount[0]);

				if (players == null) {
					return;
				}

			} catch (Exception e) {
				ShowError("Fehler", "Fehler beim öffnen der View.\nBitte starte das Programm neu.", e);
				e.printStackTrace();
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
						stage.setTitle("TripleAction - Auswahl Runde " + (i+1));
						selection = controller.show(player.getName());

						if (selection == -1) {
							return;
						}

					} catch (Exception e) {
						ShowError("Fehler", "Fehler beim öffnen der View.\nBitte starte das Programm neu.", e);
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

						Parent root = loader.load();

						controller = loader.getController();

						Scene scene = new Scene(root);
						stage.setScene(scene);
						points = controller.show(player.getName());

						if (points == -1) {
							return;
						}

					} catch (Exception e) {
						ShowError("Fehler", "Fehler beim öffnen der View.\nBitte starte das Programm neu.", e);
						return;
					}

					player.addPoints(points);
				}
			}
			try {
				
				List<Player> data = players;
				
				Collections.sort(data, new Comparator<Player>() {
					 @Override
				        public int compare(Player p1, Player p2)
				        {

				            return  p2.getPoints() - p1.getPoints();
				        }
				});
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PointsView.fxml"));
				Parent root = loader.load();

				PointsViewController controller = loader.getController();

				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setTitle("TripleAction - Punkteübersicht");
				newGame = controller.show(data);

			} catch (Exception e) {
				ShowError("Fehler Punkteübersicht",
						"Danke, dass du dieses Spiel gespielt hast.\nLeider ist beim Anzeigen der Punkte ein Fehler aufgetreten.\nStarte das Programm doch einfach nochmals und spiele noch ein paar Runden :)",
						e);
				return;
			}

		} while (newGame);
	}

	private void ShowError(String title, String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);

		alert.showAndWait();
		return;
	}

	private void ShowError(String title, String message, Exception e) {
		e.printStackTrace();
		ShowError(title, message);
		return;
	}
}
