package org.kniit.lab_2.factory;

public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Доставка по морю на корабле");
    }
}
