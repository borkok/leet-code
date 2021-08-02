package sudoku;

class SudokuBoxes extends SudokuPartitions {

    void putDigit(int rowIndex, int colIndex, char digit) {
        int boxIndex = rowIndex / 3 + colIndex / 3;
        partitions.get(boxIndex).add(digit);
    }
}
