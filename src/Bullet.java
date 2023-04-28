/**
 * Class for bullet that is able to move it and stores its coordinates
 */
public class Bullet {
    /**
     * Max amount that a player is able to shoot
     */
    private final double fireRate = 3;
    /**
     * Stores x and y coordinates of bullet
     */
    private int[] bulletCordinates;
    /**
     * Stores direction of bullet
     */
    private int[] bulletDirection;

    /**
     * Constructor for Bullet object
     * @param coordinates
     * @param direction
     */
    public Bullet(int[] coordinates, int[] direction) {
        bulletCordinates[0] = coordinates[0];
        bulletCordinates[1] = coordinates[1];
        bulletCordinates[0] = direction[0];
        bulletCordinates[1] = direction[1];
    }
    /**
     * Moves the bullet in the direction that the player is facing
     */
    public void moveBullet() {
        DamageMechanics bulletCheck = new DamageMechanics();
        
    }

    /**
     * Returns the bullet's coordinates
     * @return
     */
    public int[] getBulletCoords() { return bulletCordinates; }
}
