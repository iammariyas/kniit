package org.kniit.lab_1.task_1;

public class Main {
    public static void main(String[] args) {
        PetrolStation petrolStation = new PetrolStation(2);
        for (int i = 1; i <= 10; i++) {
            new Car(i, petrolStation).start();
        }
    }
}
