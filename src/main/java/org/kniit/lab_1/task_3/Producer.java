package org.kniit.lab_1.task_3;

public class Producer extends Thread {
    private final Storage storage;

    public Producer (Storage storage) {
        this.storage = storage;
    }

    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(300);
                storage.produce();
                System.out.printf("Производитель создал товар %d\n", i);
            }
        } catch (InterruptedException e) {
            System.out.println("Производитель остановлен");
        }
    }
}
