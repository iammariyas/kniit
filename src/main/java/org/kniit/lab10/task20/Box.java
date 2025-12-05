package org.kniit.lab10.task20;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Number> {
    private final List<T> numbers = new ArrayList<>();

    public void add(T number) {
        numbers.add(number);
    }

    public double sum() {
        double res = 0.0;
        for (T num : numbers) {
            res += num.doubleValue();
        }
        return res;
    }
}