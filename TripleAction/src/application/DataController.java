package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DataController {

	private ArrayList<String> questions = new ArrayList<String>();
	private ArrayList<String> dares = new ArrayList<String>();
	
	public static final DataController INSTANCE = new DataController();

	private DataController() {
		addAction(questions, "/tasks/questions.txt");
		addAction(dares, "/tasks/dares.txt");
	}

	public ArrayList<String> getTasks(boolean mustBeQuestion, int amount) {

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
	
	private void addAction(ArrayList<String> list, String path) {
		File file = new File(getClass().getResource(path).getFile());

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));

			String st;
			while ((st = br.readLine()) != null) {
				list.add(st);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
