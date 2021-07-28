package arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumTest {

    private static Stream<Arguments> twoSum() {
        return Stream.of(
                Arguments.of(new int[]{1,1}, 2, new int[]{0,1})
                ,Arguments.of(new int[]{1,2,1}, 2, new int[]{0,2})
                ,Arguments.of(new int[]{1,1,2}, 2, new int[]{0,1})
                ,Arguments.of(new int[]{2,1,1}, 2, new int[]{2,1})
/*
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 */
        );
    }

    @ParameterizedTest
    @MethodSource("twoSum")
    public void twoSum(int[] nums, int target, int[] expected) {
        assertThat(new TwoSum().twoSum(nums, target)).contains(expected);
    }
}