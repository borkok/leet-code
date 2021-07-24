import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {
    private static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of(new int[]{1}, 0)
                ,Arguments.of(new int[]{1,2}, 1)
                ,Arguments.of(new int[]{2,1}, 0)
                ,Arguments.of(new int[]{2,2}, 0)
                ,Arguments.of(new int[]{1,2,3}, 2)
                ,Arguments.of(new int[]{3,1,2,4}, 3)
                ,Arguments.of(new int[]{7,1,5,3,6,4}, 7)
                ,Arguments.of(new int[]{1,2,3,4,5}, 4)
                ,Arguments.of(new int[]{7,6,4,3,1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    public void test(int[] prices, int expected) {
        int profit = new Solution().maxProfit(prices);
        assertThat(profit).isEqualTo(expected);
    }
}