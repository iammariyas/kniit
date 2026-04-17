package org.kniit.lab_1.task_4;

public class Main {
    public static void main(String[] args) throws  InterruptedException{
        TrafficLight light = new TrafficLight();
        light.start();

        for (int i = 2; i <= 10; i++) {
            new Car(i, light).start();
        }
    }
}
