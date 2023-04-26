import java.util.*;

/**
 * Simulates the game by creating Player and Zombie objects and calling upon them to simulate their turns, printing the board out after each turn
 */
public class GameSim {

    /**
     * Holds all the zombies currently at play in a HashSet
     */
    HashSet<Zombie> zombies;
    /**
     * Queue that stores the amount of zombies spawned in each following wave
     */
    private final Queue<Integer> zombiesSpawn = new LinkedList<>(Arrays.asList(3, 5, 7, 9, 11));

    /**
     * Runs the actual game
     */
    public void gameSim() {
        Player player = new Player();
        zombies = zombieGeneration();

        Board board = new Board();
        board.printBoard(zombies, player);
    }

    /**
     * Generates number of zombies pertaining to the wave in queue and returns the objects in a new HashSet
     * @return the new HashSet
     */
    public HashSet<Zombie> zombieGeneration() {
        HashSet<Zombie> zombies = new HashSet<>();
        for (int i = 0; i < zombiesSpawn.remove(); i++) {
            Zombie zombie = new Zombie();
            zombies.add(zombie);
        }
        return zombies;
    }
}
