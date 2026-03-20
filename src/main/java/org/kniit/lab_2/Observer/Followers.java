package org.kniit.lab_2.Observer;

public class Followers implements Subscriber {
    private String user;

    public Followers(String user) {
        this.user = user;
    }

    @Override
    public void update(String news) {
        System.out.printf("%s получил новость: %s\n", user, news);
    }
}
