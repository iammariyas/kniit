package org.kniit.lab_1.task_6;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static final int RUNNERS = 10;
    public static final CyclicBarrier START_BARRIER = new CyclicBarrier(RUNNERS, new Starter());
    public static final CyclicBarrier END_BARRIER = new CyclicBarrier(RUNNERS, new Finisher());

    public static class Starter implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("На старт. Внимание. Марш!");
            } catch (Exception e) {
                System.err.println("Ошибка");
            }
        }
        }

    public static class Finisher implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("Все бегуны финишировали");
            } catch (Exception e) {
                System.err.println("Ошибка");
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < RUNNERS; i++) {
            new Thread(new Runner(i + 1)).start();
            System.out.printf("Бегун %d готовится к старту\n", i + 1);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
