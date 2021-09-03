package orderedList;

public class Counter {
    private int counter1 = 0;
    private int counter2 = 0;

    String getNextNumber(int i) {
        if (i == 2)  return concatWithDot(String.valueOf(counter1), String.valueOf(++counter2));
        return String.valueOf(++counter1);
    }

    String concatWithDot(String... numbers) {
        return String.join(".",numbers);
    }
}
