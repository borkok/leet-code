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

    public boolean isValidSudoku(char[][] board) {
        Sudoku sudoku = new Sudoku(board);
        return sudoku.allRowsAreValid() && sudoku.allColsAreValid() && sudoku.allBoxesAreValid();
    }

    private static class Sudoku {
        private List<SudokuPartition> rows;
        private List<SudokuPartition> cols;
        private List<SudokuPartition> boxes;

        public Sudoku(char[][] board) {
            initialize();
            for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
                for (int colIndex = 0; colIndex < 9; colIndex++) {
                    char c = board[rowIndex][colIndex];
                    if (isDigit(c)) {
                        addDigit(rowIndex, colIndex, c);
                    }
                }
            }
        }

        private void addDigit(int rowIndex, int colIndex, char digit) {
            rows.get(rowIndex).add(digit);
            cols.get(colIndex).add(digit);
            int boxIndex = rowIndex / 3 + colIndex / 3;
            boxes.get(boxIndex).add(digit);
        }

        private boolean isDigit(char c) {
            return c != '.';
        }

        private void initialize() {
            rows = new LinkedList<>();
            cols = new LinkedList<>();
            boxes = new LinkedList<>();
            for (int i = 0; i < 9; i++) {
                rows.add(new SudokuPartition());
                cols.add(new SudokuPartition());
                boxes.add(new SudokuPartition());
            }
        }

        boolean allRowsAreValid() {
            return allAreValid(rows);
        }

        boolean allColsAreValid() {
            return allAreValid(cols);
        }

        boolean allBoxesAreValid() {
            return allAreValid(boxes);
        }

        private boolean allAreValid(List<SudokuPartition> partitions) {
            for (SudokuPartition p : partitions) {
                if (p.isInvalid()) return false;
            }
            return true;
        }
    }

    private static class SudokuPartition {
        private final List<Character> digits;

        public SudokuPartition() {
            digits = new LinkedList<>();
        }

        private boolean isInvalid() {
            if (digits.isEmpty()) return false;
            Set<Character> uniqueDigits = new HashSet<>(digits);
            return uniqueDigits.size() != digits.size();
        }

        void add(char digit) {
            digits.add(digit);
        }
    }
}
