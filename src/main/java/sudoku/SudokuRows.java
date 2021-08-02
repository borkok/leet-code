/*
 * Copyright (c) 2021. BEST S.A. and/or its affiliates. All rights reserved.
 */

package sudoku;

class SudokuRows extends SudokuPartitions {

    void putDigit(int rowIndex, int colIndex, char digit) {
        partitions.get(rowIndex).add(digit);
    }
}
