import java.util.*;

/**
 * Simulates the game by creating Player and Zombie objects and calling upon them to simulate their turns, printing the board out after each turn
 */
public class GameSim {

    /**
     * Holds all the zombies currently at play in a HashSet
     */
    HashSet<Zombie> zombies;
    /**
     * Queue that stores the amount of zombies spawned in each following wave
     */
    private final Queue<Integer> zombiesSpawn = new LinkedList<>(Arrays.asList(3, 5, 7, 9, 11));

    /**
     * Runs the actual game
     */
    public void gameSim() {
        Board board = new Board();
        Player player = new Player();
        DamageMechanics mechanics = new DamageMechanics();
        zombies = zombieGeneration();

        while(player.getLives() > 0 && zombiesSpawn.size() > 0) {
            while (player.getMoves() < 3) {
                if (player.makeTurn()) {
                    player.playerMove();
                    if (mechanics.zombieTouchingPlayer(player, zombies)) {
                        player.setLives(player.getLives() - 1);
                        if (player.getLives() == 0) {
                            break;
                        }
                        player.setCoords(zombies);
                    }
                }
                else {
                    Bullet bullet = new Bullet(player.getCoords(), player.getDirection());
                    while (bullet.getBulletCoords()[0] <= 29 && bullet.getBulletCoords()[0] >= 0 && bullet.getBulletCoords()[1] <= 9 && bullet.getBulletCoords()[1] >= 0) {
                        HashSet<Zombie> newZombies = mechanics.bulletTouchingZombie(bullet, zombies);
                        if (zombies.size() != newZombies.size()) {
                            zombies = newZombies;
                            break;
                        }
                    }
                }
                player.setMoves(player.getMoves() + 1);
                board.printBoard(zombies, player);
            }

        }
    }

    /**
     * Generates number of zombies pertaining to the wave in queue and returns the objects in a new HashSet
     * @return the new HashSet
     */
    public HashSet<Zombie> zombieGeneration() {
        HashSet<Zombie> zombies = new HashSet<>();
        for (int i = 0; i < zombiesSpawn.remove(); i++) {
            Zombie zombie = new Zombie(zombies);
            zombies.add(zombie);
        }
        return zombies;
    }
}
