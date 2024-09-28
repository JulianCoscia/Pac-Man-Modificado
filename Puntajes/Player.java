package Puntajes;

public class Player {
	private int score;
	private int timePlayed;
	private String name;
	
	/**
	 * Creates a new profile for a player.
	 * @param score Score reached during the game.
	 * @param timePlayed Time played (in seconds).
	 * @param name Player's name.
	 */
	public Player(String name, int score, int timePlayed) {
		this.name = name;
		this.score = score;
		this.timePlayed = timePlayed;
	}
	
	//__________Getters___________
	/**
	 * Returns the score achieved by the player during the game.
	 * @return Player's score.
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * @return Player's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the number of seconds the player played.
	 * @return Time played (in seconds).
	 */
	public int getTimePlayed() {
		return timePlayed;
	}
}
