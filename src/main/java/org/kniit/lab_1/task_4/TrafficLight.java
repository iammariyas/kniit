package org.kniit.lab_1.task_4;

enum LightColor {
    RED,
    GREEN,
}

public class TrafficLight extends Thread {
    private LightColor current;


    public TrafficLight() {
        this.current = LightColor.RED;
    }

    public synchronized LightColor getCurrent() {
        return current;
    }

    private synchronized void switchColor() {
        if (current == LightColor.GREEN) {
            current = LightColor.RED;
        } else {
            current = LightColor.GREEN;
        }
        notifyAll();
    }

    public void run() {
        while (true) {
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                return;
            }
            switchColor();
        }
    }
}
