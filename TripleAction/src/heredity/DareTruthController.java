package heredity;

import java.util.ArrayList;

public abstract class DareTruthController implements GameCategoryController {
	
	private String caption;
	private ArrayList<String> questions;
	
	public int show(String playerName) {
		return 1;
	}
}
