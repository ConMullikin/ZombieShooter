public class DamageMechanics extends PlayerStatistics {
    private int[][] bulletCordinates;

    public boolean bulletTouchingZombie(int[][] zombieCoords) { return false; }

    public boolean zombieTouchingPlayer(int[][] zombieCoords) { return false; }
}
