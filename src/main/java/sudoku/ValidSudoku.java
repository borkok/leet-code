package sudoku;

/*
Determine if a 9 x 9 Sudoku board is valid.
Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
 */
public class ValidSudoku {

    private final SudokuRows rows = new SudokuRows();
    private final SudokuColumns cols = new SudokuColumns();
    private final SudokuBoxes boxes = new SudokuBoxes();

    public boolean isValidSudoku(char[][] board) {
        putDigits(board);
        return rows.allAreValid()
                && cols.allAreValid()
                && boxes.allAreValid();
    }

    private void putDigits(char[][] board) {
        for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
            for (int colIndex = 0; colIndex < 9; colIndex++) {
                char c = board[rowIndex][colIndex];
                if (isDigit(c)) {
                    rows.putDigit(rowIndex, colIndex, c);
                    cols.putDigit(rowIndex, colIndex, c);
                    boxes.putDigit(rowIndex, colIndex, c);
                }
            }
        }
    }

    private boolean isDigit(char c) {
        return c != '.';
    }

}
