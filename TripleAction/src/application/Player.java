package application;

public class Player {

	private String name;
	private int points = 0;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}

	public void addPoints(int amount) {
		points += amount;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}

