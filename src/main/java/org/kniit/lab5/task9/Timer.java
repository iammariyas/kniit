package org.kniit.lab5.task9;

public class Timer {
    private long timer;
    private long end;

    public Timer(int seconds) {
        this.timer = seconds * 1000L;
    }

    public void start() {
        end = System.currentTimeMillis() + timer;
    }

    public int getSeconds() {
        long finish = (end - System.currentTimeMillis()) / 1000;
        return Math.max(0, (int) finish);
    }

    public boolean isTime() {
        return System.currentTimeMillis() >= end;
    }
}
