package org.kniit.lab_2.Adapter;

public class RoundHole {
    double radius;
    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public boolean fits(RoundPeg peg) {
        return this.getRadius() >= peg.getRadius();
    }

    public void print(RoundPeg peg) {
        if (fits(peg)) {
            System.out.println("Колышек подходит к отверстию");
        } else {
            System.out.println("Колышек не подходит к отверстию");
        }
    }
}
