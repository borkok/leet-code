package arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidSudokuTest {
    private static Stream<Arguments> isValidSudoku() {
        return Stream.of(
                Arguments.of(makeEmptyBoard(), true)
        );
    }

    @ParameterizedTest
    @MethodSource("isValidSudoku")
    public void isValidSudoku(char[][] board, boolean expected) {
        assertThat(new ValidSudoku().isValidSudoku(board)).isEqualTo(expected);
    }

    private static char[][] makeEmptyBoard() {
        char[][] chars = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                chars[i][j] = '.';
            }
        }
        return chars;
    }
}