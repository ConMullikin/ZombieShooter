import java.util.HashSet;
import java.util.Random;

/**
 * Class which contains all the statistics and relevant methods for a Zombie entity
 */
public class Zombie extends GeneralStats {
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
    public Zombie() {
        Random rndm = new Random();
        int randNum = rndm.nextInt(4);

        if (randNum == 0) {
            coordinates[0] = rndm.nextInt(30);
            coordinates[1] = 0;
        } else if (randNum == 1) {
            coordinates[0] = rndm.nextInt(30);
            coordinates[1] = 9;
        } else if (randNum == 2) {
            coordinates[0] = 0;
            coordinates[1] = rndm.nextInt(10);
        } else {
            coordinates[0] = 29;
            coordinates[1] = rndm.nextInt(10);
        }
    }

    /**
     * Getter which returns the entity's position in the 2-D array
     * @return the coordinates of the entity's position in the matrix
     */
    public int[] getCoords() { return this.coordinates; }

    /**
     * Method which has the zombie move towards the player (zombies will have access to player coordinates as a
     * reference at each turn)
     */
    public void zombieMove(Player p) {
        Random rand = new Random();
        moves = 3;

        while (moves > 0) {
            int movesBefore = moves;
            int position = rand.nextInt(2);
            for (int i = 0; i < 2; i++) {
                if (position == 0) {
                    position++;
                } else {
                    position--;
                }

                if (p.getCoords()[position] > coordinates[position]) {
                    coordinates[position] += 1;
                    moves--;
                    break;
                } else if (p.getCoords()[position] < coordinates[position]) {
                    coordinates[position] -= 1;
                    moves--;
                    break;
                }
            }
            if (movesBefore == moves) {
                moves--;
            }
        }
    }
}
