package org.kniit.lab10.task19;

public class FindMax {
    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        T max = array[0];
        for (T el: array) {
            if (el.compareTo(max) > 0) {
                max = el;
            }
        }
        return max;
    }
}
