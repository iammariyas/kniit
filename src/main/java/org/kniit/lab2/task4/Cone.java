package org.kniit.lab2.task4;

public class Cone extends Shape{
    private final double radius;
    private final double h;

    public Cone(double radius, double h) {
        this.radius = radius;
        this.h = h;
    }

    @Override
    public double getVolume() {
        return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * h;
    }
}

