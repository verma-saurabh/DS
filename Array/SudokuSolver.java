package Array;

/**
 * https://leetcode.com/problems/sudoku-solver/
 * 37. Sudoku Solver
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 0) {
            return;
        }
        boolean[][] rowUsed = new boolean[9][9];
        boolean[][] colUsed = new boolean[9][9];
        boolean[][] cubeUsed = new boolean[9][9];


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - 1 - '0';
                    rowUsed[i][num] = true;
                    colUsed[num][j] = true;
                    cubeUsed[3 * (i / 3) + (j / 3)][num] = true;
                }

            }
        }

        helper(rowUsed, colUsed, cubeUsed, board, 0, 0);
        //System.out.println("");

    }

    public boolean helper(boolean[][] rowUsed, boolean[][] colUsed, boolean[][] cubeUsed, char[][] board, int i, int j) {
        if (i == 9) {
            return true;
        }
        if (j >= 9) {
            return helper(rowUsed, colUsed, cubeUsed, board, i + 1, 0);
        }

        if (board[i][j] == '.') {
            for (int num = 0; num < 9; num++) {
                if (rowUsed[i][num] || colUsed[num][j] || cubeUsed[3 * (i / 3) + (j / 3)][num]) {
                    continue;
                } else {
                    board[i][j] = (char) (num + 1 + '0');
                    rowUsed[i][num] = true;
                    colUsed[num][j] = true;
                    cubeUsed[3 * (i / 3) + (j / 3)][num] = true;
                    boolean suc = helper(rowUsed, colUsed, cubeUsed, board, i, j + 1);
                    if (!suc) {
                        board[i][j] = '.';
                        rowUsed[i][num] = false;
                        colUsed[num][j] = false;
                        cubeUsed[3 * (i / 3) + (j / 3)][num] = false;
                    } else {
                        return true;
                    }
                }
            }
        } else {
            return helper(rowUsed, colUsed, cubeUsed, board, i, j + 1);
        }
        return false;
    }
}
