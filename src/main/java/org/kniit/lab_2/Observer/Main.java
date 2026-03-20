package org.kniit.lab_2.Observer;

public class Main {
    public static void main(String[] args) {
        News channel = new News();

        Subscriber user1 = new Followers("Petya67");
        Subscriber user2 = new Followers("Vanya2004");

        channel.subscribe(user1);
        channel.subscribe(user2);
        channel.publishNews("Первый пост");
        channel.unsubscribe(user2);
        channel.publishNews("еще пост");
    }
}
