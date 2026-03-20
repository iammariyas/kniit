package org.kniit.lab_2.Observer;

import java.util.ArrayList;
import java.util.List;

public class News implements NewsChannel {
    private List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notification(String news) {
        for (Subscriber s: subscribers) {
            s.update(news);
        }
    }

    public void publishNews(String news) {
        System.out.printf("Новая новость: %s\n", news);
        notification(news);
    }


}
