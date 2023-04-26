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
    private char direction;
    /**
     * Tracks the number of times fired by the player in a given turn
     */
    private int timesFired;
    /**
     * Tracks the position of the player in the 2D array
     */
    private int[][] coordinates;

    /**
     * Constructor which instantiates a player instance and assigns all class variable with initial values
     */
    public Player() {}

    /**
     * Inherited by the Entities class, this method will formulate a turn for the player based on user input
     * and recreation in the GameSim() class
     */
    public void makeTurn() {}

    /**
     * Allows the player to move (per turn) along the horizontal and vertical axes based on input
     */
    public void playerMove() {}

    /**
     * Getter which returns the player's position in the 2-D array
     * @return the coordinates of the player's position in the matrix
     */
    public int[][] getPlayerCoords() { return coordinates; }

    /**
     * Getter used to identify/return which direction the player is facing
     * @return the direction of the player
     */
    public int getPlayerDirection() { return direction; }
}
