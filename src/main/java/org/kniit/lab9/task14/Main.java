package org.kniit.lab9.task14;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текущий сигнал светофора (RED, YELLOW, GREEN): ");
        String input = scanner.nextLine().toUpperCase().trim();
        try {
            TrafficLight current = TrafficLight.valueOf(input);
            TrafficLight next = current.getNextLight();
            System.out.printf("Следующий сигнал: %s", next.getColor());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка. Вы ввели значения, которые не относятся к светофору");
        }
        scanner.close();
    }
}
