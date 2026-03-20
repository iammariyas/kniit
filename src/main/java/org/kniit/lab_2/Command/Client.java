package org.kniit.lab_2.Command;

public class Client {
    public static void main(String[] args) {
        Cook cook = new Cook();

        Command steakOrder = new SteakCommand(cook);
        Command soupOrder = new SoupCommand(cook);

        Waiter waiter = new Waiter();
        waiter.takeOrder(steakOrder);
        waiter.takeOrder(soupOrder);
        waiter.sendOrders();
    }
}
