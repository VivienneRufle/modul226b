package application;

import java.io.IOException;
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

	private Stage stage = new Stage();;

	public GameController(Stage stage) {
		// this.stage = stage;
	}

	public void play() {

		boolean newGame;

		do {

			int[] amount;
			ArrayList<Player> players;

			try {
				
				PlayerAmountViewController controller = generateLoader("/view/PlayerAmountView.fxml", "TripleAction - Grundkofiguration").getController();
				amount = controller.show();

				if (amount[0] == 0) {
					return;
				}

			} catch (Exception e) {
				ShowError("Startfehler",
						"Scheint als w�re beim Starten des Programms ein Fehler aufgetreten :(\nBitte starte es neu.",
						e);
				return;
			}

			try {
				PlayerConfigViewController controller = generateLoader("/view/PlayerConfigView.fxml", "TripleAction - Player konfigurieren").getController();
				players = controller.show(amount[0]);

				if (players == null) {
					return;
				}

			} catch (Exception e) {
				ShowError("Fehler", "Fehler beim �ffnen der View.\nBitte starte das Programm neu.", e);
				e.printStackTrace();
				return;
			}

			for (int i = 0; i < amount[1]; i++) {

				for (Player player : players) {
					int selection;

					try {
						SelectionViewController controller = generateLoader("/view/SelectionView.fxml", "TripleAction - Auswahl Runde " + (i+1)).getController();
						selection = controller.show(player.getName());

						if (selection == -1) {
							return;
						}

					} catch (Exception e) {
						ShowError("Fehler", "Fehler beim �ffnen der View.\nBitte starte das Programm neu.", e);
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
						ShowError("Fehler", "Fehler beim �ffnen der View.\nBitte starte das Programm neu.", e);
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

				PointsViewController controller = generateLoader("/view/PointsView.fxml", "TripleAction - Punkte�bersicht").getController();
				newGame = controller.show(data);

			} catch (Exception e) {
				ShowError("Fehler Punkte�bersicht",
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
	
	private FXMLLoader generateLoader(String path, String title) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle(title);
		
		return loader;
	}
}
