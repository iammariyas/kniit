package org.kniit.lab10.task20;

public class Main {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.add(10);
        intBox.add(20);
        intBox.add(30);
        intBox.add(40);
        System.out.println(intBox.sum());

        Box<Double> doubleBox = new Box<>();
        doubleBox.add(1.5);
        doubleBox.add(2.5);
        doubleBox.add(3.5);
        System.out.println(doubleBox.sum());

        Box<Float> floatBox = new Box<>();
        floatBox.add(-3.4f);
        floatBox.add(15.0f);
        System.out.println(floatBox.sum());
    }
}