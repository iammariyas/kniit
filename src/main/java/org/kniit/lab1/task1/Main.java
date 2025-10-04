package org.kniit.lab1.task1;

public class Main {
    public static void main(String[] args) {
        StringBuilder line = new StringBuilder();
        for (int i = 1; i <= 100; i++) {
            line.append(i);
            if (i % 10 == 0) {
                line.append(",\n");
            } else {
                line.append(",");
            }
        }
        System.out.println(line);
    }
}