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
                , Arguments.of(List.of(
                                "# wordone",
                                "## wordtwo",
                                "# wordthree",
                                "## wordfour",
                                "## wordfive",
                                "### wordsix",
                                "### wordseven",
                                "# wordeight",
                                "## wordnine",
                                "### wordten",
                                "## wordeleven"),
                        List.of(
                                "1 wordone",
                                "1.1 wordtwo",
                                "2 wordthree",
                                "2.1 wordfour",
                                "2.2 wordfive",
                                "2.2.1 wordsix",
                                "2.2.2 wordseven",
                                "3 wordeight",
                                "3.1 wordnine",
                                "3.1.1 wordten",
                                "3.2 wordeleven"))
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    public void format(List<String> lines, List<String> expected) {
        assertThat(new OrderedList().format(lines)).isEqualTo(expected);
    }
}