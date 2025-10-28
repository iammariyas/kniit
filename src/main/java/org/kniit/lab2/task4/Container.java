package org.kniit.lab2.task4;

public class Container {
    private double volume;

    public Container(double volume) {
        this.volume = volume;
    }

    public void add(Shape shape) {
        double shapeVolume = shape.getVolume();
        if (shapeVolume > volume) {
            System.out.println("Недостаточно места, фигуру нельзя положить");
        }
        else {
            this.volume -= shapeVolume;
        }
    }

    public double getVolume() {
        return this.volume;
    }
}