package org.kniit.lab_1.task_5;

public class Main {
    public static void main(String[] args) {
        final int DETAILS_CNT = 10;
        Thread stamper = new Thread(new Stamper(DETAILS_CNT));
        Thread collector = new Thread(new Collector());
        Thread qaOperator = new Thread(new QAOperator(DETAILS_CNT));

        stamper.start();
        collector.start();
        qaOperator.start();

        try {
            stamper.join();
            collector.join();
            qaOperator.join();
            System.out.println("\nПроизводство завершено");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
