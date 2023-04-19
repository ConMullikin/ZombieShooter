/**
 * Hitbox detection class for player and zombie entities
 */
public class DamageMechanics {
    /**
     * Checks to see if a bullet is touching a zombie using their coords and returns true if so
     * @param bulletCoords
     * @param zombieCoords
     * @return
     */
    public boolean bulletTouchingZombie(int[][] bulletCoords, int[][] zombieCoords) { return false; }

    /**
     * Checks to see if a human is touching a zombie using their coords and returns true if so
     * @param humanCoords
     * @param zombieCoords
     * @return
     */
    public boolean zombieTouchingPlayer(int[][] humanCoords, int[][] zombieCoords) { return false; }
}
