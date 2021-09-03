/*
 * Copyright (c) 2021. BEST S.A. and/or its affiliates. All rights reserved.
 */
package orderedList;

public class Counter {
    private int counter = 1;

    String getNextNumber() {
        return String.valueOf(counter++);
    }
}
