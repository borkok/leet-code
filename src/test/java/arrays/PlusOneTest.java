package arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PlusOneTest {
    private static Stream<Arguments> plusOne() {
        return Stream.of(
                Arguments.of(new int[]{1}, new int[]{2})
                ,Arguments.of(new int[]{1,9}, new int[]{2,0})
                ,Arguments.of(new int[]{9}, new int[]{1,0})
                ,Arguments.of(new int[]{9,9,9}, new int[]{1,0,0,0})
                ,Arguments.of(new int[]{2,4,9}, new int[]{2,5,0})
                ,Arguments.of(new int[]{9,8,7,6,5,4,3,2,1,0}, new int[]{9,8,7,6,5,4,3,2,1,1})
        );
    }

    @ParameterizedTest
    @MethodSource("plusOne")
    public void plusOne(int[] nums, int[] expected) {
        assertThat(new PlusOne().plusOne(nums)).containsExactly(expected);
    }

}