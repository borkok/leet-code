/*
 * Copyright (c) 2021. BEST S.A. and/or its affiliates. All rights reserved.
 */

package arrays;

class SudokuCell {
    private final int row;
    private final int col;
    private final char digit;

    SudokuCell(int row, int col, char digit) {
        this.row = row;
        this.col = col;
        this.digit = digit;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public char getDigit() {
        return digit;
    }
}
