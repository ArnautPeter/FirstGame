import java.util.Arrays;

public class Board {

    char[][] board = new char[3][3];
    char currentPlayer;
    int count = 0;

    public Board() {
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], '_');
        }
        currentPlayer = 'X';
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
    }

    public boolean gameFinished() {

        if (count == 9) return true;

        return isWin();
    }

    public boolean makeMove(String move) {
        int x = Character.getNumericValue(move.charAt(0)) - 1;
        int y = Character.getNumericValue(move.charAt(1)) - 1;
        if (!isMoveValid(x, y))
            return false;

        board[x][y] = currentPlayer;
        count++;
        changeCurrentPlayer();
        return true;
    }

    private void changeCurrentPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    private boolean isMoveValid(int x, int y) {
        return !(x > 2 || y > 2 || x < 0 || y < 0 || board[x][y] != '_');
    }

    public char calculateWinner() {

        if (!isWin())
            return 'N';
        else {
            char invert = 'X';
            if (currentPlayer == 'X')
                invert = 'O';
            return invert;
        }
    }

    private boolean isWin() {

        char invert = 'X';
        if (currentPlayer == 'X')
            invert = 'O';

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == invert && board[i][1] == invert && board[i][2] == invert)
                return true;
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == invert && board[1][i] == invert && board[2][i] == invert)
                return true;
        }

        if (board[0][0] == invert && board[1][1] == invert && board[2][2] == invert)
            return true;

        if (board[2][0] == invert && board[1][1] == invert && board[0][2] == invert)
            return true;

        return false;
    }
}