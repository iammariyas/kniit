package org.kniit.lab2.task4;

public class Sphere extends Shape {
    private final double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.pow(radius, 3) * Math.PI;
    }
}
