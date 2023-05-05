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
     * Tracks the zombie's position in the 2-D array (i.e. on the board)
     */
    private int[] coordinates = new int[2];

    /**
     * Constructor which instantiates an instance of a zombie
     */
    public Zombie(HashSet<Zombie> zombies) {
        moves = 0;

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
    public void zombieMove(Player p) {
        Random rand = new Random();
        int[] coords = p.getCoords();
        moves = 3;
        while(moves > 0) {
            if((rand.nextInt(0,2) == 1) && (coords[0] > coordinates[0])) {
                coordinates[0] += 1;
                moves--;
            }
            else if((rand.nextInt(0,2) == 1) && (coords[0] < coordinates[0])) {
                coordinates[0] -= 1;
                moves--;
            }
            else if((rand.nextInt(0,2) == 0) && (coords[1] > coordinates[1])) {
                coordinates[1] += 1;
                moves--;
            }
            else {
                coordinates[1] -= 1;
                moves--;
            }
        }


    }

    /**
     * Getter method for the positional coordinates of a zombie
     * @return the positional coordinates for a zombie in the 2-D array
     */
    public int[] getZombieCoords() { return coordinates; }
}
