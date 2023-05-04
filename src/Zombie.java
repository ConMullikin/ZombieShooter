import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Class which contains all the statistics and relevant methods for a Zombie entity
 */
public class Zombie extends Entities {
    /**
     * Tracks the number of moves a zombie has left in a given turn
     */
    private int moves;
    /**
     * Tracks the number of lives a zombie entity has left
     */
    private int lives;
    /**
     * Tracks the zombie's position in the 2-D array (i.e. on the board)
     */
    private int[] coordinates = new int[2];

    /**
     * Constructor which instantiates an instance of a zombie
     */
    public Zombie(HashSet<Zombie> zombies) {
        moves = 0;
        lives = 1;

        ArrayList<int[]> coordinates = new ArrayList<>();
        for (Zombie zombie: zombies) {
            coordinates.add(zombie.getCoords());
        }

        boolean coordsAdded = false;
        Random rndm = new Random();
        while (!coordsAdded) {
            if(rndm.nextInt(0,1) == 0) {

            }
        }
    }

    /**
     * Method which has the zombie move towards the player (zombies will have access to player coordinates as a
     * reference at each turn)
     */
    public void zombieMove() {}

    /**
     * Getter method for the positional coordinates of a zombie
     * @return the positional coordinates for a zombie in the 2-D array
     */
    public int[] getZombieCoords() { return coordinates; }
}
