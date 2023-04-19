/**
 * Abstract class that provides the basis for Player and Zombie objects
 */
public abstract class Entities extends GeneralStats {
    private int moves;
    private int lives;

    public abstract void makeTurn();
}
