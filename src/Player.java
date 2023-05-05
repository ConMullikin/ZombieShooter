import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 * Class which contains all the information (i.e. variables and methods) relevant to the player for gameplay
 */
public class Player extends Entities {
    /**
     * Tracks the number of moves the player has left in a given turn
     */
    private int moves;
    /**
     * Tracks the number of lives (hearts) a player has left
     */
    private int lives;
    /**
     * Tracks the direction that a player faces based on key input
     */
    private int[] direction = new int[2];
    /**
     * Tracks the number of times fired by the player in a given turn
     */
    private int timesFired;
    /**
     * Tracks the position of the player in the 2D array
     */
    private int[] coordinates = new int[2];

    /**
     * Constructor which instantiates a player instance and assigns all class variable with initial values
     */
    public Player() {
        coordinates[0] = 5;
        coordinates[1] = 15;
        moves = 3;
        lives = 3;
        direction[0] = 0;
        direction[1] = 0;
    }

    /**
     * Inherited by the Entities class, this method will formulate a turn for the player based on user input
     * and recreation in the GameSim() class
     */
    public boolean makeTurn() {
        Scanner scn = new Scanner(System.in);
        boolean inputReceived = false;

        while (!inputReceived) {
            System.out.println("Press M if you wish to move and S if you wish to shoot.");
            char input = scn.next().charAt(0);

            if (input == 'M') {
                moves++;
                return true;
            } else if (input == 'S') {
                moves++;
                return false;
            }
            System.out.println("Incorrect input received, try again.");
        }
        return false;
    }

    /**
     * Allows the player to move (per turn) along the horizontal and vertical axes based on input
     * as well as change the direction that they are facing
     */
    public void playerMove() {
        System.out.println("Press L to move left, R to move right, U to move up, and D to move down.");

    }

    /**
     * Getter used to identify/return which direction the player is facing
     * @return the direction of the player
     */
    public int[] getDirection() { return direction; }

    /**
     * Returns amount of moves player has used during their turn
     * @return
     */
    public int getMoves() { return moves; }

    /**
     * Returns amount of moves player has used during their turn
     *
     */
    public void setMoves(int moves) { this.moves = moves; }


    /**
     * Randomly sets the coordinates of a player after being hit by zombie to be a position a few units more away from zombies
     * @param zombies
     */
    public void setCoords(HashSet<Zombie> zombies) {
        Random rndm = new Random();
        boolean zombieNearby;
        boolean coordsSet = false;
        int xCoordsChange = 0;
        int yCoordsChange = 0;

        while (!coordsSet) {
            zombieNearby = false;
            if (rndm.nextInt(1) == 0) {
                if (rndm.nextInt(1) == 0) {
                    xCoordsChange = 3;
                } else {
                    xCoordsChange = -3;
                }
                for (Zombie zombie : zombies) {
                    if ((zombie.getCoords()[0] >= coordinates[0] + xCoordsChange - 2) && (zombie.getCoords()[0] <= coordinates[0] + xCoordsChange + 2) && (zombie.getCoords()[1] >= coordinates[1] - 2) && (zombie.getCoords()[1] <= coordinates[1] + 2)) {
                        zombieNearby = true;
                    }
                }
                if (!zombieNearby && (coordinates[0] + xCoordsChange >= 0) && (coordinates[0] + xCoordsChange <= 29)) {
                    coordinates[0] = coordinates[0] + xCoordsChange;
                    break;
                }
            } else {
                if (rndm.nextInt(1) == 0) {
                    if (rndm.nextInt(1) == 0) {
                        yCoordsChange = 3;
                    } else {
                        yCoordsChange = -3;
                    }
                }
                for (Zombie zombie : zombies) {
                    if ((zombie.getCoords()[0] >= coordinates[0] - 2) && (zombie.getCoords()[0] <= coordinates[0] + 2) && (zombie.getCoords()[1] >= coordinates[1] + yCoordsChange - 2) && (zombie.getCoords()[1] <= coordinates[1] + yCoordsChange + 2)) {
                        zombieNearby = true;
                    }
                }
                if (!zombieNearby && (coordinates[1] + yCoordsChange >= 0) && (coordinates[1] + yCoordsChange <= 29)) {
                    coordinates[1] = coordinates[1] + yCoordsChange;
                    break;
                }
            }
        }

        if (coordinates[0] + 3 <= 29) {
            coordinates[0] = coordinates[0] + 2;
        } else if (coordinates[0] - 3 >= 0) {
            coordinates[0] = coordinates[0] - 2;
        }
    }
}
