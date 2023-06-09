import java.util.HashSet;
import java.util.Objects;

public class Board {
    /**
     * Width of the board
     */
    private final int boardWidth = 30;
    /**
     * Height of the board
     */
    private final int boardHeight = 10;
    /**
     * Holds all  the positions of the board
     */
    private String[][] board;

    /**
     * Creates an empty board
     */
    public Board() {
        board = new String[boardWidth][boardHeight];
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                board[i][j] = "*";
            }
        }
    }

    /**
     * Prints out all the positions of the entities and empty spaces in the board
     * @param zombies HashSet of all the zombies in existence, used to get their coords
     * @param player The player, used to get their coords
     */
    public void printBoard(HashSet<Zombie> zombies, Player player) {
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                board[i][j] = "*";
            }
        }

        board[player.getCoords()[0]][player.getCoords()[1]] = "X";

        for (Zombie zombie : zombies) {
            if (Objects.equals(board[zombie.getCoords()[0]][zombie.getCoords()[1]], "4")) {
                board[zombie.getCoords()[0]][zombie.getCoords()[1]] = "5";
            } else if (Objects.equals(board[zombie.getCoords()[0]][zombie.getCoords()[1]], "3")) {
                board[zombie.getCoords()[0]][zombie.getCoords()[1]] = "4";
            } else if (Objects.equals(board[zombie.getCoords()[0]][zombie.getCoords()[1]], "2")) {
                board[zombie.getCoords()[0]][zombie.getCoords()[1]] = "3";
            } else if (Objects.equals(board[zombie.getCoords()[0]][zombie.getCoords()[1]], "Z")) {
                board[zombie.getCoords()[0]][zombie.getCoords()[1]] = "2";
            } else {
                board[zombie.getCoords()[0]][zombie.getCoords()[1]] = "Z";
            }
        }

        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                System.out.print(board[j][i]);
            }
            System.out.println();
        }
    }
}
