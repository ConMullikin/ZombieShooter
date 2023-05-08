import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * Class which contains all the information (i.e. variables and methods) relevant to the player for gameplay
 */
public class Player extends GeneralStats {
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
     * Tracks the position of the player in the 2D array
     */
    private int[] coordinates = new int[2];

    /**
     * Constructor which instantiates a player instance and assigns all class variable with initial values
     */
    public Player() {
        coordinates[0] = 15;
        coordinates[1] = 5;
        moves = 3;
        lives = 3;
        direction[0] = 1;
        direction[1] = 0;
    }

    /**
     * Inherited by the Entities class, this method will formulate a turn for the player based on user input
     * and recreation in the GameSim() class
     */
    public String makeTurn() {
        Scanner scn = new Scanner(System.in);
        boolean inputReceived = false;

        System.out.println("Press M to move, S to shoot, and D to change direction.");
        while (!inputReceived) {
            String input = scn.next().toUpperCase();
            if (Objects.equals(input, "M") || Objects.equals(input, "S") || Objects.equals(input, "D")) {
                return input;
            }
            System.out.println("Incorrect input received, try again.");
        }
        return "M";
    }

    /**
     * Allows the player to move (per turn) along the horizontal and vertical axes based on input
     * as well as change the direction that they are facing
     */
    public void playerMove() {
        Scanner scn = new Scanner(System.in);
        boolean inputReceived = false;

        System.out.println("Press L or R to move left or right, U or D to move up or down, or a combination of left or right and up or down such as LU and RD.");
        while (!inputReceived) {
            String input = scn.next().toUpperCase();
            if (input.equals("L") && coordinates[0] - 1 >= 0) {
                coordinates[0] = coordinates[0] - 1;
                break;
            } else if (input.equals("R") && coordinates[0] + 1 <= 29) {
                coordinates[0] = coordinates[0] + 1;
                break;
            } else if (input.equals("U") && coordinates[1] - 1 >= 0) {
                coordinates[1] = coordinates[1] - 1;
                break;
            } else if (input.equals("D") && coordinates[0] + 1 <= 29) {
                coordinates[1] = coordinates[1] + 1;
                break;
            } else if ((input.equals("LU") || input.equals("UL")) && coordinates[0] - 1 >= 0 && coordinates[1] - 1 >= 0) {
                coordinates[0] = coordinates[0] - 1;
                coordinates[1] = coordinates[1] - 1;
                break;
            } else if ((input.equals("LD") || input.equals("DL")) && coordinates[0] - 1 >= 0 && coordinates[1] + 1 <= 9) {
                coordinates[0] = coordinates[0] - 1;
                coordinates[1] = coordinates[1] + 1;
                break;
            } else if ((input.equals("RU") || input.equals("UR")) && coordinates[0] + 1 <= 29 && coordinates[1] - 1 >= 0) {
                coordinates[0] = coordinates[0] + 1;
                coordinates[1] = coordinates[1] - 1;
                break;
            } else if ((input.equals("RD") || input.equals("DR")) && coordinates[0] + 1 <= 29 && coordinates[1] + 1 <= 9) {
                coordinates[0] = coordinates[0] + 1;
                coordinates[1] = coordinates[1] + 1;
                break;
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
        setDirection();
    }

    /**
     * Getter used to identify/return which direction the player is facing
     * @return the direction of the player
     */
    public int[] getDirection() { return direction; }

    /**
     * Sets direction of player at the beginning of the game
     */
    public void setDirection() {
        boolean inputReceived = false;
        Scanner scn = new Scanner(System.in);

        System.out.println("Press L or R to face left or right, U or D to face up or down, or a combination of left or right and up or down such as LU and RD.");
        while (!inputReceived) {
            String input = scn.next().toUpperCase();
            if (input.equals("L")) {
                direction[0] = -1;
                direction[1] = 0;
                break;
            } else if (input.equals("R")) {
                direction[0] = 1;
                direction[1] = 0;
                break;
            } else if (input.equals("U")) {
                direction[0] = 0;
                direction[1] = -1;
                break;
            } else if (input.equals("D")) {
                direction[0] = 0;
                direction[1] = 1;
                break;
            } else if (input.equals("LU") || input.equals("UL")) {
                direction[0] = -1;
                direction[1] = -1;
                break;
            } else if (input.equals("LD") || input.equals("DL")) {
                direction[0] = -1;
                direction[1] = 1;
                break;
            } else if (input.equals("RU") || input.equals("UR")) {
                direction[0] = 1;
                direction[1] = -1;
                break;
            } else if (input.equals("RD") || input.equals("DR")) {
                direction[0] = 1;
                direction[1] = 1;
                break;
            } else {
                System.out.println("Invalid direction. Please try again.");
            }
        }
    }

    /**
     * Returns player's number of lives left
     * @return
     */
    public int getLives() { return lives; }

    /**
     * Sets player's number of lives left
     * @param lives
     */
    public void setLives(int lives) { this.lives = lives; }

    /**
     * Getter which returns the entity's position in the 2-D array
     * @return the coordinates of the entity's position in the matrix
     */
    public int[] getCoords() { return this.coordinates; }

    /**
     * Getter which returns the player's number of move
     * @return the player's number of moves
     */
    public int getMoves() { return moves; }

    /**
     * Setter which sets the player's number of moves
     * @param moves
     */
    public void setMoves(int moves) { this.moves = moves; }

    /**
     * Randomly sets the coordinates of a player after being hit by zombie to be a position a few units more away from zombies
     * @param zombies
     */
    public void setCoords(HashSet<Zombie> zombies) {
        Random rndm = new Random();
        boolean coordsSet = false;
        int coordsChange = 0;
        boolean zombieInSpot;

        while (!coordsSet) {
            zombieInSpot = false;
            if (rndm.nextInt(2) == 0) {
                if (rndm.nextInt(2) == 0) {
                    coordsChange = 3;
                } else {
                    coordsChange = -3;
                }
                for (Zombie zombie : zombies) {
                    if ((zombie.getCoords()[0] == coordinates[0] + coordsChange) && (zombie.getCoords()[1] == coordinates[1])) {
                        zombieInSpot = true;
                        break;
                    }
                }
                if ((coordinates[0] + coordsChange >= 0) && (coordinates[0] + coordsChange <= 29) && !zombieInSpot) {
                    coordinates[0] = coordinates[0] + coordsChange;
                    break;
                }
            } else {
                if (rndm.nextInt(2) == 0) {
                    coordsChange = 3;
                } else {
                    coordsChange = -3;
                }
                for (Zombie zombie : zombies) {
                    if ((zombie.getCoords()[1] == coordinates[1]) && (zombie.getCoords()[1] == coordinates[1] + coordsChange)) {
                        zombieInSpot = true;
                        break;
                    }
                }
                if ((coordinates[1] + coordsChange >= 0) && (coordinates[1] + coordsChange <= 9) && !zombieInSpot) {
                    coordinates[1] = coordinates[1] + coordsChange;
                    break;
                }
            }
        }
    }
}
