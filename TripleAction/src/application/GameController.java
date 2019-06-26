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

/**
 * Ist für den Ablauf des gesamten Spiels zuständig. Übernimmt das Aufrufen der
 * Views und verwaltet deren Rückgabewerte.
 * 
 * @author Alexander Stammherr
 * @version 1.1
 *
 */
public class GameController {

	private Stage stage = new Stage();

	/**
	 * Startet das Spiel
	 */
	public void play() {

		boolean newGame;

		do {

			int[] amount;
			ArrayList<Player> players;

			try {

				PlayerAmountViewController controller = generateLoader("/view/PlayerAmountView.fxml",
						"TripleAction - Grundkofiguration").getController();
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
				PlayerConfigViewController controller = generateLoader("/view/PlayerConfigView.fxml",
						"TripleAction - Player konfigurieren").getController();
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
						SelectionViewController controller = generateLoader("/view/SelectionView.fxml",
								"TripleAction - Auswahl Runde " + (i + 1)).getController();
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

						String path = null;
						GameCategoryController controller;

						switch (selection) {
						case 0:
							path = "/view/DareView.fxml";
							break;
						case 1:
							path = "/view/TruthView.fxml";
							break;
						case 2:
							path = "/view/RiskView.fxml";
							break;
						}

						controller = generateLoader(path, null).getController();

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
					public int compare(Player p1, Player p2) {

						return p2.getPoints() - p1.getPoints();
					}
				});

				PointsViewController controller = generateLoader("/view/PointsView.fxml",
						"TripleAction - Punkteübersicht").getController();
				newGame = controller.show(data);

			} catch (Exception e) {
				ShowError("Fehler Punkteübersicht",
						"Danke, dass du dieses Spiel gespielt hast.\nLeider ist beim Anzeigen der Punkte ein Fehler aufgetreten.\nStarte das Programm doch einfach nochmals und spiele noch ein paar Runden :)",
						e);
				return;
			}

		} while (newGame);
	}

	/**
	 * Zeigt dem User eine Fehlermeldung an
	 * 
	 * @param title Der Titel der Fehlermeldung
	 * @param message Die Fehlernachricht die angezeigt werden soll
	 */
	private void ShowError(String title, String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);

		alert.showAndWait();
		return;
	}

	/**
	 * Zeigt dem User eine Fehlermeldung an
	 * 
	 * @param title Der Titel der Fehlermeldung
	 * @param message Die Fehlernachricht die angezeigt werden soll
	 * @param e Die Fehlermeldung die auf der Console ausgegeben werden soll
	 */
	private void ShowError(String title, String message, Exception e) {
		e.printStackTrace();
		ShowError(title, message);
		return;
	}

	/**
	 *  Generiert einen FXMLLoader mit dem angegeben Pfad.
	 *  Setzt den Titel der Stage und weist dieser eine Scene zu.
	 *  MAcht die Stage anzeigefähig.
	 *  
	 * @param path Pfad zur .fxml-Datei
	 * @param title Titel der Stage
	 * @return Generierter Loader
	 * @throws IOException
	 * @see FXMLLoader
	 */
	private FXMLLoader generateLoader(String path, String title) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		stage.setScene(scene);
		if (title != null && title != "") {
			stage.setTitle(title);
		}
		return loader;
	}
}
