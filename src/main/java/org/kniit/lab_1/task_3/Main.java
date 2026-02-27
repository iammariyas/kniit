package org.kniit.lab_1.task_3;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage(5);

        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);

        producer.start();
        consumer.start();
    }
}
