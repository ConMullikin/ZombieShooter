import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Simulates the game by creating Player and Zombie objects and calling upon them to simulate their turns, printing the board out after each turn
 */
public class GameSim {

    ArrayList<Zombie> zombies = new ArrayList<>();
    /**
     * Number of zombies spawned in the first wave
     */
    private int numZombies = 3;
    /**
     * Queue that stores the amount of zombies spawned in each following wave
     */
    private final Queue<Integer> zombiesSpawn = new LinkedList<>(Arrays.asList(3, 5, 7, 9, 11));

    /**
     * Runs the actual game
     */
    public void gameSim() {
        Board board = new Board();
        board.printBoard();
    }

    /**
     * Generates number of zombies pertaining to the wave in queue and returns the objects in an arraylist
     * @return
     */
    public ArrayList<Zombie> zombieGeneration() {
        ArrayList<Zombie> zombies = new ArrayList<Zombie>();
        return zombies;
    }
}
