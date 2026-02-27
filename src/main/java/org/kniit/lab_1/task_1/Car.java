package org.kniit.lab_1.task_1;

public class Car extends Thread{
    private final PetrolStation station;
    private final int num;

    public Car(int num, PetrolStation station) {
        this.num = num;
        this.station = station;
    }

    public void run() {
        try {
            station.acquire();
            System.out.printf("Машина %d начала заправку\n", num);
            Thread.sleep(1000);
            System.out.printf("Машина %d заправилась и уехала\n", num);
        } catch (InterruptedException e) {
            System.out.printf("Заправка машины %d прервана\n", num);
        } finally {
            station.release();
        }
    }
}
