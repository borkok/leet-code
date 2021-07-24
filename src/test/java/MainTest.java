import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {
    private static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of(new int[]{1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    public void test(int[] prices, int expected) {
        int profit = new Main().maxProfit(prices);
        assertThat(profit).isEqualTo(expected);
    }
}