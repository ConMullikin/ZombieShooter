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

    public void printBoard() {
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
