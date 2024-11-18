package problems.backtracking.sum;

import problems.Problem;
import problems.ProblemType;
import problems.exceptions.BadValueException;

import java.util.InputMismatchException;
import java.util.Scanner;

import static utils.MatrixUtils.copyOf;

public class QueenProblem implements Problem {

    private int[][] board;

    @Override
    public void solve() {
        this.startValue();

        this.findPossibleSolution(copyOf(board), 0);

        System.out.println(this.toString());
    }

    public void startValue() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the size of the board: ");

            int value = scanner.nextInt();

            if (value < 2) {
                throw new BadValueException("Value can't be lower than two");
            }

            this.board = createBoard(value);
        } catch (InputMismatchException e) {
            throw new BadValueException("Value must be an integer");
        }
    }

    @Override
    public ProblemType getType() {
        return ProblemType.BACKTRACKING_QUEEN_PROBLEM;
    }

    private boolean findPossibleSolution(int[][] board, int currentCol) {
        if (currentCol >= board.length) {
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            if (canPlaceQueen(board, i, currentCol)) {
                board[i][currentCol] = 1;

                if (findPossibleSolution(board, currentCol + 1)) {
                    this.board = board;

                    return true;
                }

                board[i][currentCol] = 0;
            }
        }

        return false;
    }

    private boolean canPlaceQueen(int[][] board, int row, int col) {
        int i, j;

        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) return false;
        }

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        for (i = row, j = col; j >= 0 && i < board.length; i++, j--) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    /*
     * This method created a board nxn.
     * 0 represents an empty space, 1 represents a queen
     * @param n the size of the board
     * @return int[][]
     */
    private int[][] createBoard(int n) {
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }

        return board;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int[] row : board) {
            for (int col : row) {
                stringBuilder
                        .append(" | ")
                        .append(col == 1 ? " Q " : " X ")
                        .append(" | ");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}

