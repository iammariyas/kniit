package org.kniit.lab_1.task_4;

public class Car extends Thread {
    private final int car;
    private final TrafficLight trafficLight;

    public Car(int car, TrafficLight trafficLight) {
        this.car = car;
        this.trafficLight = trafficLight;
    }

    public void run() {
         synchronized (trafficLight) {


             try {
                 while (trafficLight.getCurrent() == LightColor.RED) {
                     System.out.printf("Машина %d стоит на светофоре\n", car);
                     sleep(100);
                     trafficLight.wait();
                 }
                 System.out.printf("Машина %d едет\n",car);
                 sleep(100);
             } catch (InterruptedException e) {
                 return;
             }
         }
    }
}
