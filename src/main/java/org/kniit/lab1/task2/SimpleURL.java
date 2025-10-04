package org.kniit.lab1.task2;

/* Ссылка из условия:
https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText */
public class SimpleURL {
    private String protocol;
    private String host;
    private String path;
    private int intParam;
    private double doubleParam;
    private String textParameter;


    public SimpleURL(String url) {
        parseUrl(url);
    }


    private void parseUrl(String url) {
        String[] url_split = url.split("://");
        this.protocol = url_split[0];

        String[] domain = url_split[1].split("/", 2);
        this.host = domain[0];
        String[] toPath = domain[1].split("\\?");
        this.path = toPath[0];

        if (url.contains("intParam=")) {
            int start = url.indexOf("intParam=") + 9;
            int end = url.indexOf("&", start);
            if (end == -1) {
                end = url.length();
            }

            String number = url.substring(start, end);
            this.intParam = Integer.parseInt(number);
        }

        if (url.contains("doubleParam=")) {
            int start = url.indexOf("doubleParam=") + 12;
            int end = url.indexOf("&", start);
            if (end == -1) {
                end = url.length();
            }

            String number = url.substring(start, end);
            this.doubleParam = Double.parseDouble(number);
        }

        if (url.contains("textParameter=")) {
            int start = url.indexOf("textParameter=") + 14; //
            int end = url.indexOf("&", start);
            if (end == -1) {
                end = url.length(); //
            }

            this.textParameter = url.substring(start, end);
        }
    }

    // Геттеры:
    public String getProtocol() {
        return protocol;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public int getIntParam() {
        return intParam;
    }

    public double getDoubleParam() {
        return doubleParam;
    }

    public String getTextParameter() {
        return textParameter;
    }

    // Сеттеры:
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setIntParam(int intParam) {
        this.intParam = intParam;
    }

    public void setDoubleParam(double doubleParam) {
        this.doubleParam = doubleParam;
    }

    public void setTextParameter(String textParameter) {
        this.textParameter = textParameter;
    }

    // Переопределим метод toString():
    @Override
    public String toString() {
        return String.format("protocol = %s\nhost = %s\npath = %s\n" +
                        "intParam = %s\ndoubleParam = %s\ntextParameter = %s", protocol, host, path,
                intParam, doubleParam, textParameter);
    }
}

