package org.kniit.lab_1.task_1;

public class PetrolStation {
    private final int maxAvailable;
    private int taken;

    public PetrolStation(int maxAvailable) {
        this.maxAvailable = maxAvailable; //2
        this.taken = 0;
    }

    public synchronized void acquire() throws InterruptedException {
        while (this.taken == maxAvailable) {
            wait();
        }
        this.taken++;
    }

    public synchronized void release() {
        this.taken--;
        this.notify();
    }
}
