package org.kniit.lab_2.Observer;

public interface NewsChannel {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notification(String news);
}
