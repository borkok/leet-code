/*
 * Copyright (c) 2021. BEST S.A. and/or its affiliates. All rights reserved.
 */

package sudoku;

class SudokuBuilder {
    private final SudokuCell[] cells;

    static char[][] emptyBoard() {
        char[][] chars = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                chars[i][j] = '.';
            }
        }
        return chars;
    }

    static SudokuBuilder withFilledCells(SudokuCell... cells) {
        return new SudokuBuilder(cells);
    }

    SudokuBuilder(SudokuCell[] cells) {
        this.cells = cells;
    }

    public char[][] build() {
        char[][] board = emptyBoard();
        for (SudokuCell cell : cells) {
            board[cell.getRow()][cell.getCol()] = cell.getDigit();
        }
        return board;
    }
}
