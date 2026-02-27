package org.kniit.lab_1.task_2;

public class Tray {
    private final int maxAvailable;
    private int taken;

    public Tray(int maxAvailable) {
        this.maxAvailable = maxAvailable; //3
        this.taken = 0;
    }

    public synchronized void acquire() throws InterruptedException {
        while (this.taken == maxAvailable) {
            System.out.printf("Повар: поднос полон (%d), ожидание...\n", taken);
            wait();
        }
        this.taken++;
        notify();
    }

    public synchronized void release() throws InterruptedException {
        while (this.taken == 0) {
            wait();
        }
        this.taken--;
        this.notify();
    }
}
