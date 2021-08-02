/*
 * Copyright (c) 2021. BEST S.A. and/or its affiliates. All rights reserved.
 */

package sudoku;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class SudokuPartition {
    private final List<Character> digits;

    public SudokuPartition() {
        digits = new LinkedList<>();
    }

    boolean isInvalid() {
        if (digits.isEmpty()) return false;
        Set<Character> uniqueDigits = new HashSet<>(digits);
        return uniqueDigits.size() != digits.size();
    }

    void add(char digit) {
        digits.add(digit);
    }
}
