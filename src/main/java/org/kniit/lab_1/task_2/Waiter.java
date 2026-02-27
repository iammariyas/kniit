package org.kniit.lab_1.task_2;

public class Waiter extends Thread {
    private final Tray tray;

    public Waiter(Tray tray) {
        this.tray = tray;
    }
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(800);
                tray.release();
                System.out.printf("Официант подал блюдо %d\n", i);
            } catch (InterruptedException e) {}
        }
    }
}
