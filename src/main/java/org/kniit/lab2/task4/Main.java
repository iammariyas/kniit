package org.kniit.lab2.task4;

public class Main {
    public static void main(String[] args) {
        Container container = new Container(1000);
        Sphere sphere = new Sphere(5);
        Cube cube = new Cube(3);
        Cone cone = new Cone(5, 10);
        container.add(sphere);
        container.add(cube);
        container.add(cone);
        System.out.println(container.getVolume());

        System.out.println("\n----------------------");
        System.out.println("Проверка");
        System.out.println(1000 - ((4.0 / 3.0 * Math.PI * Math.pow(5, 3))
                + Math.pow(3, 3) + 1.0 / 3.0 * Math.PI * Math.pow(5, 2) * 10));
    }
}
