package orderedList;

import java.util.List;
import java.util.stream.Collectors;

/*
Given sequence of strings
# wordone
wordtwo
# wordthree
## wordfour
## wordfive
wordsix
# wordseven
## wordeight
### wordnine
### wordten

replace hash sign with correct chapter number meaning, ignoring lines without hash:
1 wordone
2 wordtwo
2.1 wordfour
2.2 wordfive
3 wordseven
3.1 wordeight
3.1.1 wordnine
3.1.2 wordten
 */
public class OrderedList {
    public List<String> format(List<String> lines) {
        Counter counter = new Counter();
        return lines.stream()
                .filter(s -> s.startsWith("#"))
                .map(s -> s.replaceAll("#+", counter.nextNumber(level(s))))
                .collect(Collectors.toList());
    }

    private int level(String s) {
        return s.lastIndexOf("#") + 1;
    }
}
