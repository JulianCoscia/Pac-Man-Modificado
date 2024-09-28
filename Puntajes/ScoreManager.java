package Puntajes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * ScoreManager is responsible for handling the storage and management
 * of player scores in a file located in the user's Documents folder.
 * It allows saving new scores, retrieving the highest score, and sorting the scores.
 */
public class ScoreManager {
	private Path FILE_PATH;
	private File scoreFile; 

	//____________________ Constructor ____________________
    /**
     * Constructor that creates the score file in the user's Documents folder if it doesn't exist yet. 
     * If the file exists, it just stores the file path.
     */
    public ScoreManager() {
        // Get the user's "Documents" folder path
        String userHome = System.getProperty("user.home");
        Path documentsPath = Paths.get(userHome, "Documents");

        FILE_PATH = Paths.get(documentsPath.toString(), "Pac-Man ScoreList.txt");

        // Check if the file already exists
        scoreFile = FILE_PATH.toFile();
        if (!scoreFile.exists()) {
            try {
                scoreFile.createNewFile();
            } catch (IOException e) {
                System.err.println("Error creating the file: " + e.getMessage());
            }
        }
    }
    
    //____________________ Methods ____________________

    /**
     * Saves the last played score to the file. The scores are stored in descending order.
     * @param newPlayer The Player object containing the new player's name, score, and time played.
     */
    public void saveScore(Player newPlayer) {
        List<Player> playerList = new ArrayList<>();
        String line;

        // Read the file and load existing players into a list
        try (BufferedReader reader = Files.newBufferedReader(FILE_PATH)) {
            line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int score = Integer.parseInt(parts[1]);
                int timePlayed = Integer.parseInt(parts[2]);
                playerList.add(new Player(name, score, timePlayed));
                
                // Move to the next line
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        playerList.add(newPlayer);

        // Sort the player list by score from highest to lowest
        Collections.sort(playerList, (p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()));

        // Write the sorted list back to the file
        try (BufferedWriter writer = Files.newBufferedWriter(FILE_PATH)) {
            for (Player player : playerList) {
                writer.write(player.getName() + "," + player.getScore() + "," + player.getTimePlayed());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    /**
     * Retrieves the highest score from the file.
     * The highest score is assumed to be the first entry in the file if it is sorted.
     * @return A Player object representing the player with the highest score, or null if the file is empty.
     */
    public Player getHighestScore() {
        try (BufferedReader reader = Files.newBufferedReader(FILE_PATH)) {
            String line = reader.readLine();
            if (line != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int score = Integer.parseInt(parts[1]);
                int timePlayed = Integer.parseInt(parts[2]);
                return new Player(name, score, timePlayed);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return null;
    }
}
