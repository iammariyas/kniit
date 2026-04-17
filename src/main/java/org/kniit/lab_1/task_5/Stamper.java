package org.kniit.lab_1.task_5;

public class Stamper implements Runnable {
    private final int detailsToCollector;

    public Stamper(int detailsToCollector) {
        this.detailsToCollector = detailsToCollector;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= detailsToCollector; i++) {
                Detail detail = new Detail(i);
                System.out.printf("Штамповщик: заготовка %d создана\n", i);
                DetailObject.detailsForCollector.put(detail);
                Thread.sleep(100);
            }
            DetailObject.detailsForCollector.put(new Detail(-1));
            System.out.println("Штамповщик завершил работу");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
