import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board {
    private final int boardWidth = 30;
    private final int boardHeight = 10;
    private String[][] board;

    public Board() {
        board = new String[boardHeight][boardWidth];
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                board[i][j] = "*";
            }
        }
    }

    public void printBoard(ArrayList<Zombie> zombies, Player player) {
        board[player.getPlayerCoords()[0]][player.getPlayerCoords()[1]] = "X";

        for (int i = 0; i < zombies.size(); i++) {
            board[zombies.get(i).getCoords()[0]][zombies.get(i).getCoords()[1]] = "Z";
        }

        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
