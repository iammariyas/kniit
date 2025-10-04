package org.kniit.lab1.task2;

public class Main {
    public static void main(String[] args) {
        String url = "https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText";
        String url1 = "ssh://test.ru/test/1072/pagejsp?intParam=12345&doubleParam=3.14&textParameter=someText";
        String url2 = "ssh://test.ru/test/1072/pagejsp";

        SimpleURL simpleURL = new SimpleURL(url);
        SimpleURL simpleURL1 = new SimpleURL(url1);
        SimpleURL simpleURL2 = new SimpleURL(url2);
        System.out.println(simpleURL.toString());
        System.out.println("\n--------------------\n");
        System.out.println(simpleURL1.toString());
        System.out.println("\n--------------------\n");
        System.out.println(simpleURL2.toString());
    }
}
