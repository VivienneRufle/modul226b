package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DataController {

	private ArrayList<String> questions = new ArrayList<String>();
	private ArrayList<String> dares = new ArrayList<String>();
	
	public DataController() {
		
	}

	public ArrayList<String> getQuestions(boolean mustBeQuestion, int amount) {

		ArrayList<String> list;

		if (mustBeQuestion) {
			list = questions;
		} else {
			list = dares;
		}

		List<String> copy = new LinkedList<String>(list);
		Collections.shuffle(copy);
		
		return new ArrayList<String>(copy.subList(0, amount));
	}
}
