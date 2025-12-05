package org.kniit.lab10.task22;

public class Main {
    public static void main(String[] args) {
        Dictionary<String, Integer> dictionary = new Dictionary<>();
        dictionary.put("Alice", 25);
        dictionary.put("Bob", 30);
        System.out.println(dictionary.get("Alice"));

        dictionary.remove("Alice");
        System.out.println(dictionary.get("Alice"));
    }
}
