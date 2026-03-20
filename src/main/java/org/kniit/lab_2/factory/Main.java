package org.kniit.lab_2.factory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logistics logistics = null;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите тип доставки: ");
        String type = scanner.nextLine();

        if (type.equals("sea")) {
            logistics = new SeaLogistics();
        } else if (type.equals("road")) {
            logistics = new RoadLogistics();
        } else {
            System.out.println("Неизвестный тип логистики");
        }
        if (logistics != null) {
            logistics.makeDelivery();
        }
    }
}
