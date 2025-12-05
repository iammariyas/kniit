package org.kniit.lab9.task14;

public enum TrafficLight {
    RED ("RED"),
    YELLOW ("YELLOW"),
    GREEN ("GREEN");

    private final String color;

    TrafficLight(String color) {
        this.color = color;
    }

    public TrafficLight getNextLight() {
        return TrafficLight.values()[(this.ordinal() + 1) % TrafficLight.values().length];
    }
    public String getColor() {
        return color;
    }
}
