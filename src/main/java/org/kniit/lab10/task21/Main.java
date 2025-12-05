package org.kniit.lab10.task21;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<String> filtered = Filter.filter(words, s -> s.startsWith("b"));
        System.out.println(filtered); // [banana]
    }
}
