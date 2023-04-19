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
     * Follows through for the entity's move for that turn
     */
    public abstract void makeTurn();
}
