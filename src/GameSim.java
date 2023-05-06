import java.util.*;

/**
 * Simulates the game by creating Player and Zombie objects and calling upon them to simulate their turns, printing the board out after each turn
 */
public class GameSim {

    /**
     * Holds all the zombies currently at play in a HashSet
     */
    HashSet<Zombie> zombies = new HashSet<>();
    /**
     * Queue that stores the amount of zombies spawned in each following wave
     */
    private final Queue<Integer> zombiesSpawn = new LinkedList<>(Arrays.asList(3, 5, 7, 9, 11));

    /**
     * Runs the actual game
     */
    public void gameSim() {
        Board board = new Board();
        GeneralStats genStats = new GeneralStats();
        Player player = new Player();
        DamageMechanics mechanics = new DamageMechanics();
        zombies = zombieGeneration();
        board.printBoard(zombies, player);

        while(player.getLives() > 0 && !zombiesSpawn.isEmpty()) {
            while (player.getMoves() > 0) {
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
                        bullet.moveBullet();
                        mechanics.bulletTouchingZombie(bullet, zombies);
                        if (zombies.isEmpty()) {
                            zombies = zombieGeneration();
                        }
                    }
                }
                player.setMoves(player.getMoves() - 1);
                if (player.getMoves() != 0) {
                    board.printBoard(zombies, player);
                }
            }
            genStats.setTurns(genStats.getTurns() + 1);
            for (Zombie zombie : zombies) {
                zombie.zombieMove(player, zombies);
            }
            board.printBoard(zombies, player);
            player.setMoves(3);
        }
        if (player.getLives() > 0) {
            System.out.println("Congrats, you win!");
        } else {
            System.out.println("Sorry, you lose!");
        }
        System.out.println("You lasted " + genStats.getTurns() + " turns and killed " + genStats.getKills() + " zombies.");
    }

    /**
     * Generates number of zombies pertaining to the wave in queue and returns the objects in a new HashSet
     * @return the new HashSet
     */
    public HashSet<Zombie> zombieGeneration() {
        int numZombies = zombiesSpawn.remove();

        while (zombies.size() < numZombies) {
            Zombie zombie = new Zombie(zombies);
            zombies.add(zombie);
        }
        return zombies;
    }
}
