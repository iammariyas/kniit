package org.kniit.lab_2.Command;

import java.util.ArrayList;
import java.util.List;

public class Waiter {
    private List<Command> orders = new ArrayList<>();

    public void takeOrder(Command order) {
        orders.add(order);
    }

    public void sendOrders() {
        for (Command order: orders) {
            order.execute();
        }
        orders.clear();
    }
}
