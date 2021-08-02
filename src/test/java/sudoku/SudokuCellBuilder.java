package sudoku;

class SudokuCellBuilder {
    private int row;
    private int col;
    private char digit = '1';

    static SudokuCellBuilder aCell() {
        return new SudokuCellBuilder();
    }

    SudokuCellBuilder row(int row) {
        this.row = row;
        return this;
    }

    SudokuCellBuilder col(int col) {
        this.col = col;
        return this;
    }

    SudokuCellBuilder digit(char d) {
        this.digit = d;
        return this;
    }

    SudokuCell build() {
        return new SudokuCell(row, col, digit);
    }

}
