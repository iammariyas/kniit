package org.kniit.lab10.task23;

public class Main {
    public static <T> void printType(T obj) {
        System.out.println(obj.getClass().getName());
    }

    public static void main(String[] args) {
        printType(123); // java.lang.Integer
        printType("Hello"); // java.lang.String
        printType(3.14);
    }
}
