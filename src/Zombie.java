import java.util.ArrayList;
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
    public Zombie(HashSet<Zombie> zombies) {
        moves = 3;

        boolean coordsAdded = false;
        boolean spaceAvailable;
        Random rndm = new Random();

        while (!coordsAdded) {
            spaceAvailable = true;
            if (rndm.nextInt(0,4) == 0) {
                coordinates[0] = rndm.nextInt(30);
                coordinates[1] = 0;
            }
            if (rndm.nextInt(0,4) == 1) {
                coordinates[0] = rndm.nextInt(30);
                coordinates[1] = 9;
            }
            if (rndm.nextInt(0,4) == 2) {
                coordinates[0] = 0;
                coordinates[1] = rndm.nextInt(10);
            }
            if (rndm.nextInt(0,4) == 3) {
                coordinates[0] = 29;
                coordinates[1] = rndm.nextInt(10);
            }
            for (Zombie zombie : zombies) {
                if (zombie.getCoords()[0] == coordinates[0] && zombie.getCoords()[1] == coordinates[1]) {
                    spaceAvailable = false;
                    break;
                }
            }
            if (spaceAvailable) {
                break;
            }
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
    public void zombieMove(Player p, HashSet<Zombie> zombies) {
        Random rand = new Random();
        int[] coords = p.getCoords();
        moves = 3;
        boolean touchingZombie;

        while(moves > 0) {
            touchingZombie = false;
            if((rand.nextInt(0,2) == 1) && (coords[0] > coordinates[0])) {
                for (Zombie zombie : zombies) {
                    if ((zombie.getCoords()[0] == coordinates[0] + 1) && (zombie.getCoords()[1] == coordinates[1])) {
                        touchingZombie = true;
                        break;
                    }
                }
                if (!touchingZombie) {
                    coordinates[0] += 1;
                    moves--;
                }
            }
            else if((rand.nextInt(0,2) == 1) && (coords[0] < coordinates[0])) {
                for (Zombie zombie : zombies) {
                    if ((zombie.getCoords()[0] == coordinates[0] - 1) && (zombie.getCoords()[1] == coordinates[1])) {
                        touchingZombie = true;
                        break;
                    }
                }
                if (!touchingZombie) {
                    coordinates[0] -= 1;
                    moves--;
                }
            }
            else if((rand.nextInt(0,2) == 0) && (coords[1] > coordinates[1])) {
                for (Zombie zombie : zombies) {
                    if ((zombie.getCoords()[0] == coordinates[0]) && (zombie.getCoords()[1] == coordinates[1] + 1)) {
                        touchingZombie = true;
                        break;
                    }
                }
                if (!touchingZombie) {
                    coordinates[1] += 1;
                    moves--;
                }
            }
            else if ((rand.nextInt(0,2) == 0) && (coords[1] < coordinates[1])) {
                for (Zombie zombie : zombies) {
                    if ((zombie.getCoords()[0] == coordinates[0]) && (zombie.getCoords()[1] == coordinates[1] - 1)) {
                        touchingZombie = true;
                        break;
                    }
                }
                if (!touchingZombie) {
                    coordinates[1] -= 1;
                    moves--;
                }
            }
        }
    }

    /**
     * Getter method for the positional coordinates of a zombie
     * @return the positional coordinates for a zombie in the 2-D array
     */
    public int[] getZombieCoords() { return coordinates; }
}
