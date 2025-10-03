package org.kniit.lab2.task3;

import java.util.Scanner;

public class Main {
    static public void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Calculator calc = new Calculator();
        System.out.println("Введите exit для выхода:");

        while (true) {
            System.out.println("Введите два числа:");

            String inputA = input.next();
            if (inputA.equals("exit")) {
                break;
            }

            String inputB = input.next();
            if (inputB.equals("exit")) {
                break;
            }

            double a = Double.parseDouble(inputA);
            double b = Double.parseDouble(inputB);

            System.out.println("Введите оператор (+, -, *, /):");
            String operator = input.next();
            if (operator.equals("exit")) {
                break;
            }

            double res = 0;
            boolean flag = true;

            if (operator.equals("+")) {
                res = calc.add(a, b);
            } else if (operator.equals("-")) {
                res = calc.subtract(a, b);
            } else if (operator.equals("*")) {
                res = calc.multiply(a, b);
            } else if (operator.equals("/")) {
                if (b == 0) {
                    System.out.println("На ноль делить нельзя!");
                    flag = false;
                } else {
                    res = calc.divide(a, b);
                }
            } else {
                System.out.println("Такой оператор не предусматривается!");
                flag = false;
            }
            if (flag) {
                System.out.printf("Результат: %s\n", res);
            }
        }
    }
}
