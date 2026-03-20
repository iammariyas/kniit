package org.kniit.lab_2.singleton;

public class Singleton {
    private static Singleton instance = null;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    public void print() {
        System.out.println("Выполнился принцип проектирования Синглтон");
    }
}
