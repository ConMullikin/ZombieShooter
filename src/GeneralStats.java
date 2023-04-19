/**
 * Class used to track general game statistics
 */
public class GeneralStats {

    /**
     * Integer value which keeps tracvk of the current turn
     */
    private int turnCounter = 0;

    /**
     * Integer value which tracks the number of enemies you have killed
     */
    private int killCounter = 0;

    /**
     * Getter method for the private class variable turnCounter
     * @return the current value of the class variable turnCounter
     */
    public int getTurns() { return turnCounter; }

    /**
     * Getter method for the private class variable killCounter
     * @return the current value of the class variable killCounter
     */
    public int getKills() { return killCounter; }
}
