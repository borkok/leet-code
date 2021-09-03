package orderedList;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import strings.ReverseInteger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderedListTest {
    private static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of(List.of("word"), List.of())
                , Arguments.of(List.of("# word"), List.of("1 word"))
                , Arguments.of(List.of("# wordone", "# wordtwo"), List.of("1 wordone", "2 wordtwo"))
                , Arguments.of(List.of("# wordone", "## wordtwo"), List.of("1 wordone", "1.1 wordtwo"))
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    public void format(List<String> lines, List<String> expected) {
        assertThat(new OrderedList().format(lines)).isEqualTo(expected);
    }
}