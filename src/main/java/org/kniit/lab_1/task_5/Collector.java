package org.kniit.lab_1.task_5;

public class Collector implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                Detail detail = DetailObject.detailsForCollector.take();
                if (detail.getId() == -1) {
                    DetailObject.detailsForQA.put(detail);
                    System.out.println("Сборщик завершил работу");
                    break;
                }
                System.out.printf("Сборщик: Заготовка %d собрана\n", detail.getId());
                DetailObject.detailsForQA.put(detail);
                Thread.sleep(150);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
