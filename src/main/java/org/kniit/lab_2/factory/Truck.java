package org.kniit.lab_2.factory;

public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Доставка по суше на грузовике");
    }
}
