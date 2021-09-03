package orderedList;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Counter {
    private List<Integer> counters = new LinkedList<>();
    private int counter1 = 0;
    private int counter2 = 0;

    String nextNumber(int level) {
        trimSmallerLevelsThan(level);
        increaseCounterAt(level);
        return concatAllLevelsWithDot();
    }

    private void trimSmallerLevelsThan(int maxLevel) {
        for (int index = counters.size()-1; index > maxLevel-1; index--) {
            counters.remove(index);
        }
    }

    private void increaseCounterAt(int level) {
        if (counters.size() < level) {
            while (counters.size() < level) {
                counters.add(1);
            }
        } else {
            int newValue = counters.get(level - 1) + 1;
            counters.set(level - 1, newValue);
        }
    }

    String concatAllLevelsWithDot() {
        return counters.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("."));
    }
}
