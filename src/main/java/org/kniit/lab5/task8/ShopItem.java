package org.kniit.lab5.task8;

import java.util.Objects;

public class ShopItem {
    private String name;
    private double price;
    private int count;

    public ShopItem(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("---Товарная позиция---\n" +
                "Название: %s\n" +
                "Количество: %s\n" +
                "Цена: %.2f\n", name, count, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj == null || !(obj instanceof ShopItem)) { return false; }
        ShopItem other = (ShopItem) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() { return Objects.hash(name); }

    public double getPrice() { return price; }

    public String getName() { return name; }
}
