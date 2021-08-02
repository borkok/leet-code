/*
 * Copyright (c) 2021. BEST S.A. and/or its affiliates. All rights reserved.
 */

package sudoku;

import java.util.LinkedList;
import java.util.List;

class Sudoku {
    private List<SudokuRow> rows;
    private List<SudokuColumn> cols;
    private List<SudokuBox> boxes;

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
            rows.add(new SudokuRow());
            cols.add(new SudokuColumn());
            boxes.add(new SudokuBox());
        }
    }

    boolean allRowsAreValid() {
        return rows.stream().noneMatch(SudokuPartition::isInvalid);
    }

    boolean allColsAreValid() {
        return cols.stream().noneMatch(SudokuPartition::isInvalid);
    }

    boolean allBoxesAreValid() {
        return boxes.stream().noneMatch(SudokuPartition::isInvalid);
    }

}
