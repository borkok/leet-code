package sudoku;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidSudokuTest {
    private static Stream<Arguments> isValidSudoku() {
        return Stream.of(
                Arguments.of(SudokuBuilder.emptyBoard(), true)
                , Arguments.of(
                        SudokuBuilder.withFilledCells(
                                SudokuCellBuilder.aCell().row(0).col(0).digit('1').build(),
                                SudokuCellBuilder.aCell().row(0).col(1).digit('1').build()
                        ).build(), false)
                , Arguments.of(
                        SudokuBuilder.withFilledCells(
                                SudokuCellBuilder.aCell().row(0).col(0).digit('1').build(),
                                SudokuCellBuilder.aCell().row(0).col(1).digit('2').build()
                        ).build(), true)
                , Arguments.of(
                        SudokuBuilder.withFilledCells(
                                SudokuCellBuilder.aCell().row(0).col(0).digit('1').build(),
                                SudokuCellBuilder.aCell().row(0).col(1).digit('2').build(),
                                SudokuCellBuilder.aCell().row(1).col(0).digit('1').build()
                        ).build(), false)
                , Arguments.of(
                        SudokuBuilder.withFilledCells(
                                SudokuCellBuilder.aCell().row(0).col(0).digit('1').build(),
                                SudokuCellBuilder.aCell().row(0).col(1).digit('2').build(),
                                SudokuCellBuilder.aCell().row(1).col(0).digit('3').build()
                        ).build(), true)
                , Arguments.of(
                        SudokuBuilder.withFilledCells(
                                SudokuCellBuilder.aCell().row(0).col(0).digit('1').build(),
                                SudokuCellBuilder.aCell().row(0).col(1).digit('2').build(),
                                SudokuCellBuilder.aCell().row(1).col(0).digit('2').build()
                        ).build(), false)
/*                , Arguments.of(
                        new char[][] {
                                  { '5', '3', '.', '.', '7', '.', '.', '.', '.' }
                                , { '6', '.', '.', '1', '9', '5', '.', '.', '.' }
                                , { '.', '9', '8', '.', '.', '.', '.', '6', '.' }
                                , { '8', '.', '.', '.', '6', '.', '.', '.', '3' }
                                , { '4', '.', '.', '8', '.', '3', '.', '.', '1' }
                                , { '7', '.', '.', '.', '2', '.', '.', '.', '6' }
                                , { '.', '6', '.', '.', '.', '.', '2', '8', '.' }
                                , { '.', '.', '.', '4', '1', '9', '.', '.', '5' }
                                , { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
                        }, true
                )*/
        );
    }

    @ParameterizedTest
    @MethodSource("isValidSudoku")
    public void isValidSudoku(char[][] board, boolean expected) {
        assertThat(new ValidSudoku().isValidSudoku(board)).isEqualTo(expected);
    }

}