/*
 * Copyright (c) 2021. BEST S.A. and/or its affiliates. All rights reserved.
 */

package arrays;

public class SudokuBuilder {
    static char[][] emptyBoard() {
        char[][] chars = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                chars[i][j] = '.';
            }
        }
        return chars;
    }
}
