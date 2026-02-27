package org.kniit.lab_1.task_2;

public class Cook extends Thread {
    private final Tray tray;

    public Cook (Tray tray) {
        this.tray = tray;
    }

    public void run() {
        try {
            for (int i = 1; i <= 10; i ++) {
                Thread.sleep((400));
                tray.acquire();
                System.out.printf("Повар приготовил блюдо %d\n", i);
            }
        } catch (InterruptedException e) {
               System.out.println("Повар прервал готовку");
        }
    }
}

