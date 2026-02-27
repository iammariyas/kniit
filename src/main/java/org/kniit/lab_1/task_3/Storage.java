package org.kniit.lab_1.task_3;

public class Storage {
    private final int maxAvailable;
    private int taken;

    public Storage(int maxAvailable) {
        this.maxAvailable = maxAvailable; //5
        this.taken = 0;
    }

    public synchronized void produce() throws InterruptedException {
        while (this.taken == maxAvailable) {
            System.out.printf("Производитель: склад полон %d. Ожидание...\n", taken);
            wait();
        }
        this.taken++;
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (this.taken == 0) {
            System.out.printf("Со стороны потребителя: склад пуст %d. Ожидание...\n", taken);
            wait();
        }
        this.taken--;
        System.out.printf("Потребитель забрал товар, осталось: %d\n", taken);
        this.notify();
    }
}
