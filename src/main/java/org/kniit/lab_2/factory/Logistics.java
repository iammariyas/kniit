package org.kniit.lab_2.factory;

public abstract class Logistics {
    protected abstract Transport createTransport();
    public void makeDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }
}
