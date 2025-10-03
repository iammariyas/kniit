package org.kniit.lab1.task2;

public class Main {
    public static void main(String[] args) {
        String url = "https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText";

        SimpleURL simpleURL = new SimpleURL(url);
        System.out.println(simpleURL.toString());
    }
}
