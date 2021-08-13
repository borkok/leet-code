package strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {
    private static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of(1, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    public void reverse(int number, int expected) {
        assertThat(new ReverseInteger().reverse(number)).isEqualTo(expected);
    }
}