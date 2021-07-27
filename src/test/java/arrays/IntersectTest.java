package arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IntersectTest {

    private static Stream<Arguments> intersect() {
        return Stream.of(
                Arguments.of(new int[]{1}, new int[]{2}, new int[]{})
                ,Arguments.of(new int[]{1}, new int[]{1}, new int[]{1})
                ,Arguments.of(new int[]{1,2,2,1}, new int[]{2,2}, new int[]{2,2})
                ,Arguments.of(new int[]{4,9,5}, new int[]{9,4,9,8,4}, new int[]{4,9})
        );
    }

    @ParameterizedTest
    @MethodSource("intersect")
    public void intersect(int[] nums, int[] otherNums, int[] expected) {
        assertThat(new Intersect().intersect(nums, otherNums)).contains(expected);
    }
}