package org.kniit.lab2.task4;

public class Cilindre extends Shape{
    private final double radius;
    private final double h;

    public Cilindre(double radius, double h) {
        this.radius = radius;
        this.h = h;
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * h;
    }
}

