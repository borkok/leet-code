package orderedList;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Counter {
    private List<Integer> counters = new LinkedList<>();
    private int counter1 = 0;
    private int counter2 = 0;

    String nextNumber(int level) {
        trimRight(level);
        increaseCounter(level);
        return concatWithDot();
    }

    private void trimRight(int newSize) {
        for (int index = counters.size()-1; index > newSize-1; index--) {
            counters.remove(index);
        }
    }

    private void increaseCounter(int level) {
        if (counters.size() < level) {
            while (counters.size() < level) {
                counters.add(1);
            }
        } else {
            int newValue = counters.get(level - 1) + 1;
            counters.set(level - 1, newValue);
        }
    }

    String concatWithDot() {
        return counters.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("."));
    }
}
