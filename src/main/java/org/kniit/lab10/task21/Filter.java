package org.kniit.lab10.task21;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filter {
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> res = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                res.add(item);
            }
        }
        return res;
    }
}
