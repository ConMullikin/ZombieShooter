import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GameSim {
    private int numZombies = 3;
    private final Queue<Integer> zombiesSpawn = new LinkedList<>(Arrays.asList(3, 5, 7, 9, 11));

    public void gameSim() {}

    public ArrayList<Zombie> zombieGeneration() {
        ArrayList<Zombie> zombies = new ArrayList<Zombie>();
        return zombies;
    }
}
