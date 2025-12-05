package org.kniit.lab9.task15;

public enum Season {
    Зима("Очень холодно", "Новый год"),
    Весна("Тепло", "Пасха"),
    Лето("Жарко", "День Дня"),
    Осень("Дождливо", "День Учителя");

    private final String temperature;
    private final String holiday;

    Season(String temperature, String holiday) {
        this.temperature = temperature;
        this.holiday = holiday;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHoliday() {
        return holiday;
    }
}
