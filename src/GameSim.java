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
    private Queue<Integer> zombiesSpawn;

    /**
     * Sims the game
     */
    public void gameSim() {
        Board board = new Board();
        DamageMechanics mechanics = new DamageMechanics();
        GeneralStats genStats = new GeneralStats();
        Player player = new Player();
        Scanner scn = new Scanner(System.in);

        boolean inputReceived = false;
        String input;
        System.out.println("Press E for easy difficulty, M for medium difficulty, and H for hard difficulty.");
        while (!inputReceived) {
            input = scn.next().toUpperCase();
            if (input.equals("E")) {
                zombiesSpawn = new LinkedList<>(Arrays.asList(3,5,7));
                break;
            } else if (input.equals("M")) {
                zombiesSpawn = new LinkedList<>(Arrays.asList(3,5,7,9,11));
                break;
            } else if (input.equals("H")) {
                zombiesSpawn = new LinkedList<>(Arrays.asList(3,5,7,9,11,13,15));
                break;
            }
            System.out.println("Invalid input, please try again.");
        }

        zombieGeneration();
        board.printBoard(zombies, player);
        player.setDirection();

        while(player.getLives() > 0 && (!zombiesSpawn.isEmpty() || !zombies.isEmpty())) {
            while (player.getMoves() > 0) {
                input = player.makeTurn();
                if (Objects.equals(input, "M")) {
                    player.playerMove();
                } else if (Objects.equals(input, "S")) {
                    Bullet bullet = new Bullet(player.getCoords(), player.getDirection());
                    while (bullet.getCoords()[0] <= 29 && bullet.getCoords()[0] >= 0 && bullet.getCoords()[1] <= 9 && bullet.getCoords()[1] >= 0) {
                        bullet.moveBullet();
                        if (mechanics.bulletTouchingZombie(bullet, zombies)) {
                            genStats.setKills(genStats.getKills() + 1);
                            break;
                        }
                    }
                } else {
                    player.setDirection();
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
                    if (mechanics.zombieTouchingPlayer(player, zombies)) {
                        if (player.getLives() == 0) {
                            break;
                        }
                        player.setLives(player.getLives() - 1);
                        System.out.println("Ouch! You are down to " + player.getLives() + " lives left.");
                        player.setCoords(zombies);
                    }
                    player.setMoves(3);
                }
                if (player.getMoves() != 0) {
                    board.printBoard(zombies, player);
                }
            }
            genStats.setTurns(genStats.getTurns() + 1);
            for (Zombie zombie : zombies) {
                zombie.zombieMove(player);
            }
            if (mechanics.zombieTouchingPlayer(player, zombies)) {
                if (player.getLives() == 0) {
                    break;
                }
                player.setLives(player.getLives() - 1);
                System.out.println("Ouch! You are down to " + player.getLives() + " lives left.");
                player.setCoords(zombies);
                player.setMoves(3);
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
