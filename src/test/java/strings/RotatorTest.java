package strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RotatorTest {
    private static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of(new char[]{'a'}, new char[]{'a'}),
                Arguments.of(new char[]{'a','b'}, new char[]{'b','a'}),
                Arguments.of(new char[]{'a','b','c'}, new char[]{'c','b','a'}),
                Arguments.of(new char[]{'h','e','l','l','o'}, new char[]{'o','l','l','e','h'})
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    public void reverseString(char[] text, char[] expected) {
        new Rotator().reverseString(text);
        assertThat(text).containsExactly(expected);
    }
}