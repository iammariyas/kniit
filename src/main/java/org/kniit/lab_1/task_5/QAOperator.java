package org.kniit.lab_1.task_5;

public class QAOperator implements Runnable {
    private final int detailsToCheck;

    public QAOperator(int detailsToCheck) {
        this.detailsToCheck = detailsToCheck;
    }

    @Override
    public void run() {
        try {
            int checked = 0;
            while (checked < detailsToCheck) {
                Detail detail = DetailObject.detailsForQA.take();
                if (detail.getId() == -1) {
                    break;
                }
                System.out.printf("Оператор контроля качества: " +
                        "Деталь %d проверена и отправлена на склад\n", detail.getId());
                checked++;
                Thread.sleep(120);
            }
            System.out.printf("Оператор контроля качества: Завершил работу. Проверено деталей: %d\n", checked);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
