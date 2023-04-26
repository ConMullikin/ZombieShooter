/**
 * Abstract class that provides the basis for Player and Zombie objects
 */
public abstract class Entities extends GeneralStats {
    /**
     * Keeps track of moves done by entity in their turn
     */
    private int moves;
    /**
     * Number of lives that entity has left
     */
    private int lives;
    /**
     * Tracks the position of the entity in the 2D array
     */
    private int[] coordinates;

    /**
     * Follows through for the entity's move for that turn
     */
    public abstract void makeTurn();

    /**
     * Getter which returns the entity's position in the 2-D array
     * @return the coordinates of the entity's position in the matrix
     */
    public int[] getCoords() { return coordinates; }
}
