package arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of(new int[]{1}, 0, new int[]{1})
                ,Arguments.of(new int[]{1}, 1, new int[]{1})
                ,Arguments.of(new int[]{1,2}, 1, new int[]{2,1})
                ,Arguments.of(new int[]{1,2}, 2, new int[]{1,2})
                ,Arguments.of(new int[]{1,2,3,4,5,6,7}, 3, new int[]{5,6,7,1,2,3,4})
                ,Arguments.of(new int[]{-1,-100,3,99}, 2, new int[]{3,99,-1,-100})
                ,Arguments.of(new int[]{1,2,3,4,5,6,7}, 17, new int[]{5,6,7,1,2,3,4})
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    public void test(int[] nums, int k, int[] expected) {
        new Solution().rotate(nums, k);
        assertThat(nums).containsExactly(expected);
    }

    private static Stream<Arguments> params4Contains() {
        return Stream.of(
                Arguments.of(new int[]{1}, false)
                ,Arguments.of(new int[]{1,1}, true)
                ,Arguments.of(new int[]{1,2,3,1}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("params4Contains")
    public void contains(int[] nums, boolean expected) {
        assertThat(new Solution().containsDuplicate(nums)).isEqualTo(expected);
    }

    private static Stream<Arguments> params4SingleNum() {
        return Stream.of(
                Arguments.of(new int[]{1}, 1)
                ,Arguments.of(new int[]{1,1,2}, 2)
                ,Arguments.of(new int[]{-1,-1,-2}, -2)
                ,Arguments.of(new int[]{-1,-1,2}, 2)
                ,Arguments.of(new int[]{1,1,2,2,-3}, -3)
                ,Arguments.of(new int[]{1,2,3,1,2}, 3)
                ,Arguments.of(new int[]{4,1,2,1,2}, 4)
                ,Arguments.of(new int[]{5,5,3,3,2,1,1}, 2)
                ,Arguments.of(new int[]{5,5,3,50,1,3,1}, 50)
        );
    }

    @ParameterizedTest
    @MethodSource("params4SingleNum")
    public void singleNum(int[] nums, int expected) {
        assertThat(new Solution().singleNumber(nums)).isEqualTo(expected);
    }

    private static Stream<Arguments> intersect() {
        return Stream.of(
                Arguments.of(new int[]{1}, new int[]{2}, new int[]{})
                //,Arguments.of(new int[]{1,2,2,1}, new int[]{2,2}, new int[]{2,2})
                //,Arguments.of(new int[]{4,9,5}, new int[]{9,4,9,8,4}, new int[]{4,9})
        );
    }

    @ParameterizedTest
    @MethodSource("intersect")
    public void intersect(int[] nums, int[] otherNums, int[] expected) {
        assertThat(new Solution().intersect(nums, otherNums)).contains(expected);
    }
}