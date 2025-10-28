package org.kniit.lab2.task4;

public class Cube extends Shape {
    private final double a;

    public Cube(double a) {
        this.a = a;
    }

    @Override
    public double getVolume() {
        return Math.pow(a, 3);
    }
}
