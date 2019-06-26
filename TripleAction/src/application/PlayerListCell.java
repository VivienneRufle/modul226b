package application;

import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Stellt eine bearbeitbare ListCell dar. Dieser ListCell steht ein
 * Player-Objekt dahinter, dessen name-Attribut durch diese ListCell bearbeitet
 * werden kann
 * 
 * @author Alexander Stammherr
 * @version 1.0
 * @see Player
 * @see javafx.scene.control.ListCell
 *
 */
public class PlayerListCell extends ListCell<Player> {
	private final TextField textField = new TextField();

	/**
	 * Initialisiert die Zelle und definiert die KeyEvents
	 */
	public PlayerListCell() {
		textField.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
			if (e.getCode() == KeyCode.ESCAPE) {
				cancelEdit();
			}
		});
		textField.setOnAction(e -> {
			commitEdit(getItem());
			getItem().setName(textField.getText());
			setText(textField.getText());
			setContentDisplay(ContentDisplay.TEXT_ONLY);
		});
		setGraphic(textField);
	}

	@Override
	protected void updateItem(Player player, boolean empty) {
		super.updateItem(player, empty);
		if (isEditing()) {
			textField.setText(player.getName());
			setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
		} else {
			setContentDisplay(ContentDisplay.TEXT_ONLY);
			if (empty) {
				setText(null);
			} else {
				setText(player.getName());
			}
		}
	}

	@Override
	public void startEdit() {
		super.startEdit();
		textField.setText(getItem().getName());
		setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
		textField.requestFocus();
		textField.selectAll();
	}

	@Override
	public void cancelEdit() {
		super.cancelEdit();
		setText(getItem().getName());
		setContentDisplay(ContentDisplay.TEXT_ONLY);
	}

	@Override
	public void commitEdit(Player player) {
		super.commitEdit(player);
	}
}
