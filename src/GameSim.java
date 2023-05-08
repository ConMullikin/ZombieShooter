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
    private final Queue<Integer> zombiesSpawn = new LinkedList<>(Arrays.asList(3, 5));

    /**
     * Runs the actual game
     */
    public void gameSim() {
        Board board = new Board();
        GeneralStats genStats = new GeneralStats();
        Player player = new Player();
        DamageMechanics mechanics = new DamageMechanics();
        zombieGeneration();
        board.printBoard(zombies, player);
        player.setDirection();

        while(player.getLives() > 0 && (!zombiesSpawn.isEmpty() || !zombies.isEmpty())) {
            while (player.getMoves() > 0) {
                if (player.makeTurn()) {
                    player.playerMove();
                }
                else {
                    Bullet bullet = new Bullet(player.getCoords(), player.getDirection());
                    while (bullet.getBulletCoords()[0] <= 29 && bullet.getBulletCoords()[0] >= 0 && bullet.getBulletCoords()[1] <= 9 && bullet.getBulletCoords()[1] >= 0) {
                        bullet.moveBullet();
                        if (mechanics.bulletTouchingZombie(bullet, zombies)) {
                            genStats.setKills(genStats.getKills() + 1);
                            break;
                        }
                    }
                }
                player.setMoves(player.getMoves() - 1);
                if (mechanics.zombieTouchingPlayer(player, zombies)) {
                    player.setLives(player.getLives() - 1);
                    if (player.getLives() == 0) {
                        break;
                    }
                    System.out.println("Ouch! You are down to " + player.getLives() + " lives left.");
                    player.setCoords(zombies);
                    player.setMoves(3);
                }
                if (zombies.isEmpty()) {
                    if (zombiesSpawn.isEmpty()) {
                        break;
                    }
                    zombieGeneration();
                    player.setMoves(3);
                }
                if (player.getMoves() != 0) {
                    board.printBoard(zombies, player);
                }
            }
            genStats.setTurns(genStats.getTurns() + 1);
            for (Zombie zombie : zombies) {
                zombie.zombieMove(player);
                if (mechanics.zombieTouchingPlayer(player, zombies)) {
                    if (player.getLives() == 0) {
                        break;
                    }
                    player.setLives(player.getLives() - 1);
                    System.out.println("Ouch! You are down to " + player.getLives() + " lives left.");
                    player.setCoords(zombies);
                    player.setMoves(3);
                    break;
                }
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
    public void zombieGeneration() {
        int numZombies = zombiesSpawn.remove();

        while (zombies.size() < numZombies) {
            Zombie zombie = new Zombie();
            zombies.add(zombie);
        }
    }
}
