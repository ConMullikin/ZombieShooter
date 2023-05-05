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
            char input = scn.next().toUpperCase().charAt(0);

            if (input == 'M') {
                return true;
            } else if (input == 'S') {
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
        Scanner scn = new Scanner(System.in);
        boolean inputReceived = false;

        while (!inputReceived) {
            System.out.println("Press L to move left, R to move right, U to move up, and D to move down.");
            char input = scn.next().toUpperCase().charAt(0);

            if (input == 'L') {
                if (coordinates[0] - 1 >= 0) {
                    coordinates[0] -= 1;
                    break;
                }
                System.out.println("Can't move player there because you would be out of bounds. Please try again.");
            } else if (input == 'R') {
                if (coordinates[0] + 1 <= 29) {
                    coordinates[0] += 1;
                    break;
                }
                System.out.println("Can't move player there because you would be out of bounds. Please try again.");
            } else if (input == 'U') {
                if (coordinates[1] + 1 <= 29) {
                    coordinates[1] += 1;
                    break;
                }
                System.out.println("Can't move player there because you would be out of bounds. Please try again.");
            } else if (input == 'D') {
                if (coordinates[1] - 1 >= 0) {
                    coordinates[1] -= 1;
                    break;
                }
                System.out.println("Can't move player there because you would be out of bounds. Please try again.");
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }

        while (!inputReceived) {
            System.out.println("Press L or R to face left or right, U or D to face up or down, or a combination of the left or right and up or down such as LU and RD.");
            String input = scn.next().toUpperCase();

            if (input.equals("L")) {
                direction[0] = -1;
                break;
            } else if (input.equals("R")) {
                direction[0] = 1;
                break;
            } else if (input.equals("U")) {
                direction[1] = 1;
                break;
            } else if (input.equals("D")) {
                direction[1] = -1;
                break;
            } else if (input.equals("LU")) {
                direction[0] = -1;
                direction[1] = 1;
                break;
            } else if (input.equals("LD")) {
                direction[0] = -1;
                direction[1] = -1;
                break;
            } else if (input.equals("RU")) {
                direction[0] = 1;
                direction[1] = 1;
                break;
            } else if (input.equals("RD")) {
                direction[0] = 1;
                direction[1] = -1;
                break;
            } else {
                System.out.println("Invalid direction. Please try again.");
            }
        }
    }

    /**
     * Getter used to identify/return which direction the player is facing
     * @return the direction of the player
     */
    public int[] getDirection() { return direction; }

    /**
     * Randomly sets the coordinates of a player after being hit by zombie to be a position a few units more away from zombies
     * @param zombies
     */
    public void setCoords(HashSet<Zombie> zombies) {
        Random rndm = new Random();
        boolean zombieNearby;
        boolean coordsSet = false;
        int coordsChange = 0;

        while (!coordsSet) {
            zombieNearby = false;

            if (rndm.nextInt(2) == 0) {
                if (rndm.nextInt(2) == 0) {
                    coordsChange = 3;
                } else {
                    coordsChange = -3;
                }
                for (Zombie zombie : zombies) {
                    if ((zombie.getCoords()[0] >= coordinates[0] + coordsChange - 2) && (zombie.getCoords()[0] <= coordinates[0] + coordsChange + 2) && (zombie.getCoords()[1] >= coordinates[1] - 2) && (zombie.getCoords()[1] <= coordinates[1] + 2)) {
                        zombieNearby = true;
                    }
                }
                if (!zombieNearby && (coordinates[0] + coordsChange >= 0) && (coordinates[0] + coordsChange <= 29)) {
                    coordinates[0] = coordinates[0] + coordsChange;
                    break;
                }
            } else {
                if (rndm.nextInt(2) == 0) {
                    if (rndm.nextInt(2) == 0) {
                        coordsChange = 3;
                    } else {
                        coordsChange = -3;
                    }
                }
                for (Zombie zombie : zombies) {
                    if ((zombie.getCoords()[0] >= coordinates[0] - 2) && (zombie.getCoords()[0] <= coordinates[0] + 2) && (zombie.getCoords()[1] >= coordinates[1] + coordsChange - 2) && (zombie.getCoords()[1] <= coordinates[1] + coordsChange + 2)) {
                        zombieNearby = true;
                    }
                }
                if (!zombieNearby && (coordinates[1] + coordsChange >= 0) && (coordinates[1] + coordsChange <= 29)) {
                    coordinates[1] = coordinates[1] + coordsChange;
                    break;
                }
            }
        }

        if (coordinates[0] + 3 <= 29) {
            coordinates[0] = coordinates[0] + 2;
        } else {
            coordinates[0] = coordinates[0] - 2;
        }
    }
}
