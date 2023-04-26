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
    private int[] coordinates;

    /**
     * Constructor which instantiates an instance of a zombie
     */
    public Zombie() {}

    /**
     * Method inherited from the Entities class which formulates a turn for a given Zombie entity to be executed
     * in the GameSim class
     */
    public void makeTurn() {}

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
