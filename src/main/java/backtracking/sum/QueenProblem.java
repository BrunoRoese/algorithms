package backtracking.sum;

import static utils.MatrixUtils.copyOf;

public class QueenProblem {

    private int[][] board;

    public QueenProblem(int n) {
        if (n < 2) {
            throw new RuntimeException("Board can't have a dimension lower than two");
        }

        this.board = createBoard(n);

        findPossibleSolution(copyOf(board), 0);
    }

    private void findPossibleSolution(int[][] board, int currentRow) {
        if (currentRow == board.length) {
            System.out.println("teste");
            this.board = board;
            return;
        }

        for (int i = 0; i < board.length; i++) {
            System.out.println(this.toString());
            if (canPlaceQueen(board, currentRow, i)) {
                board[currentRow][i] = 1;
                findPossibleSolution(board, currentRow + 1);
            }
        }

        this.board = board;
    }

    private boolean canPlaceQueen(int[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 1) return false;
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 1) return false;
        }

        for (int i = row; i > 0; i--) {
            for (int j = col; j > 0; j--) {
                System.out.println(board[i][j]);
                if (board[i][j] == 1) {
                    System.out.println("false");
                    return false;
                }
            }
        }

        for (int i = row + 1; i < 0; i++) {
            for (int j = col + 1; j > 0; j--) {
                if (board[i][j] == 1) return false;
            }
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
                        .append(col)
                        .append(" | ");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}

