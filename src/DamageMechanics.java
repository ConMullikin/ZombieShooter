import java.util.HashSet;

/**
 * Hitbox detection class for player and zombie entities
 */
public class DamageMechanics {
    /**
     * Checks to see if a bullet is touching any of the zombie using their coords
     * and moves the bullet in the direction the player is facing if not
     * @param bullet
     * @param zombies
     * @param player
     * @return
     */
    public HashSet<Zombie> bulletTouchingZombie(Bullet bullet, HashSet<Zombie> zombies, Player player) {
        int[] bulletCoords = bullet.getBulletCoords();
        for (Zombie zombie : zombies) {
            if (bulletCoords[0] == zombie.getCoords()[0] && bulletCoords[1] == zombie.getCoords()[1]) {
                zombies.remove(zombie);
                return zombies;
            }
        }

        bulletCoords[0] += player.getPlayerDirection()[0];
        bulletCoords[1] += player.getPlayerDirection()[1];
        return zombies;
    }

    /**
     * Checks to see if a human is touching a zombie using their coords and returns true if so
     * @param player
     * @param zombies
     * @return
     */
    public boolean zombieTouchingPlayer(Player player, HashSet<Zombie> zombies) {
        for (Zombie zombie : zombies) {
            if (player.getCoords()[0] == zombie.getCoords()[0] && player.getCoords()[1] == zombie.getCoords()[1]) {
                zombies.remove(zombie);
                return true;
            }
        }
        return false;
    }
}
