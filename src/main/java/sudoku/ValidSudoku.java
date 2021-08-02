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

    public boolean isValidSudoku(char[][] board) {
        Sudoku sudoku = new Sudoku(board);
        return sudoku.allRowsAreValid() && sudoku.allColsAreValid() && sudoku.allBoxesAreValid();
    }

}
