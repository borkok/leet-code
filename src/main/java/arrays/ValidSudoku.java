package arrays;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
    private char[][] board;

    public boolean isValidSudoku(char[][] board) {
        this.board = board;
        return allRowsAreValid();// && allColsAreValid() && allBoxesAreValid();
    }

    private boolean allRowsAreValid() {
        for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
            if (!sudokuPartitionIsValid(board[rowIndex])) return false;
        }
        return true;
    }

    private boolean sudokuPartitionIsValid(char[] chars) {
        List<Character> digitsList = retrieveDigitsOnly(chars);
        if (digitsList.isEmpty()) return true;
        Set<Character> uniqueDigits = new HashSet<>(digitsList);
        return uniqueDigits.size() == digitsList.size();
    }

    private List<Character> retrieveDigitsOnly(char[] chars) {
        List<Character> digits = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            if (chars[i] != '.') digits.add(chars[i]);
        }
        return digits;
    }
}
