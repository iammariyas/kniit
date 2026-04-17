package org.kniit.lab_1.task_6;

import java.util.concurrent.BrokenBarrierException;

public class Runner implements Runnable {
    private final int id;

    public Runner(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        try {
            Main.START_BARRIER.await();
            System.out.printf("Бегун %d стартовал\n", id);
            Thread.sleep((long) (Math.random() * 3000));
            System.out.printf("Бегун %d финишировал\n", id);
            Main.END_BARRIER.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.printf("Бегун %d был прерван\n", id);
        } catch (BrokenBarrierException e) {
            System.err.printf("Барьер для бегуна %d сломан\n", id);
        }
    }
}
