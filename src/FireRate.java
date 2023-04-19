/**
 * Class for bullet that is able to move it and stores its coordinates
 */
public class FireRate extends Player {
    /**
     * Max amount that a player is able to shoot
     */
    private final double fireRate = 3;
    /**
     * Stores x and y coordinates of bullet
     */
    private int[][] bulletCordinates;

    /**
     * Moves the bullet in the direction that the player is facing
     */
    public void moveBullet(char direction) {}

    /**
     * Returns the bullet's coordinates
     * @return
     */
    public int[][] getBulletCoords() { return bulletCordinates; }
}
