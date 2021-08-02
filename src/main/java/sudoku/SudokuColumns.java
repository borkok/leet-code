package sudoku;

class SudokuColumns extends SudokuPartitions {

    void putDigit(int rowIndex, int colIndex, char digit) {
        partitions.get(colIndex).add(digit);
    }
}
