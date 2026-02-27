package org.kniit.lab_1.task_2;

public class Main {
    public static void main(String[] args) {
        Tray tray = new Tray(3);

        Cook cook = new Cook(tray);
        Waiter waiter = new Waiter(tray);

        cook.start();
        waiter.start();
    }
}
