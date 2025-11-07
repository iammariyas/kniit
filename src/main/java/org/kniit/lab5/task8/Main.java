package org.kniit.lab5.task8;
import java.util.*;

public class Main {
    static public void main(String[] args) {
        String[] names = {"книга", "ручка", "линейка", "пенал"};
        Random random = new Random();
        ShopItem[] items = new ShopItem[100];

        for (int i = 0; i < 100; i++) {
            int index = random.nextInt(names.length);
            String name = names[index];
            double price = random.nextDouble(100);
            int count = random.nextInt(1000);

            ShopItem item = new ShopItem(name, price, count);
            items[i] = item;
        }
        Comparator<ShopItem> comparator = (o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice());
        Arrays.sort(items, comparator);

        for (ShopItem item: items) { System.out.println(item); }

        Map<ShopItem, Integer> counter = new HashMap<>();
        for (ShopItem item: items) { counter.put(item, counter.getOrDefault(item, 0) + 1); }

        System.out.println("===========");
        System.out.println("Количество одинаковых товаров:");
        for (Map.Entry<ShopItem, Integer> entry: counter.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.printf("%s: %s\n", entry.getKey().getName(), entry.getValue());
            }
        }
    }
}
