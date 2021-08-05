package arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RotateMatrixTest {
    private static Stream<Arguments> rotate() {
        return Stream.of(
                //1x1
                Arguments.of(new int[][]{{1}}, new int[][]{{1}})
                ,Arguments.of(new int[][]{{1,2},{3,4}}, new int[][]{{3,1},{4,2}})
         );
    }

    @ParameterizedTest
    @MethodSource("rotate")
    public void rotate(int[][] matrix, int[][] expected) {
        new RotateMatrix().rotate(matrix);
        assertThat(matrix).isDeepEqualTo(expected);
    }

}