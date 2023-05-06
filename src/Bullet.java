/**
 * Class for bullet that is able to move it and stores its coordinates
 */
public class Bullet {
    /**
     * Stores x and y coordinates of bullet
     */
    private int[] bulletCoordinates = new int[2];
    /**
     * Stores direction of bullet
     */
    private int[] bulletDirection = new int[2];

    /**
     * Constructor for Bullet object
     * @param coordinates
     * @param direction
     */
    public Bullet(int[] coordinates, int[] direction) {
        bulletCoordinates[0] = coordinates[0];
        bulletCoordinates[1] = coordinates[1];
        bulletDirection[0] = direction[0];
        bulletDirection[1] = direction[1];
    }
    /**
     * Moves the bullet in the direction that the player is facing
     */
    public void moveBullet() {
        bulletCoordinates[0] += bulletDirection[0];
        bulletCoordinates[1] += bulletDirection[1];
    }

    /**
     * Returns the bullet's coordinates
     * @return
     */
    public int[] getBulletCoords() { return bulletCoordinates; }
}
