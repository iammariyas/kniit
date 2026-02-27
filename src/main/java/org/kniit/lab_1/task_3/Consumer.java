package org.kniit.lab_1.task_3;

public class Consumer extends Thread {
    private final Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(700);
                storage.consume();
                System.out.printf("Потребитель забрал товар %d\n", i);
            }
        } catch (InterruptedException e) {
            System.out.println("Потребитель остановлен");
        }
    }
}
