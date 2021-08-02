package sudoku;

import java.util.LinkedList;
import java.util.List;

abstract class SudokuPartitions {

    protected final List<SudokuPartition> partitions = new LinkedList<>();

    SudokuPartitions() {
        for (int i = 0; i < 9; i++) {
            partitions.add(new SudokuPartition());
        }
    }

    abstract void putDigit(int rowIndex, int colIndex, char digit);

    boolean allAreValid() {
        return partitions.stream().noneMatch(SudokuPartition::isInvalid);
    }
}
