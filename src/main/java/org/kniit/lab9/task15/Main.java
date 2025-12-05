package org.kniit.lab9.task15;

public class Main {
    static public void main(String[] args) {
        for (Season season : Season.values()) {
            System.out.printf("%s: %s, типичный праздник - %s\n",
                    season.name(), season.getTemperature(), season.getHoliday());
        }
    }
}
