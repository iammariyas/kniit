package org.kniit.lab9.task16;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();

        for (Suit suit: Suit.values()) {
            for (Rank rank: Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }

        for (Card card: deck) {
            System.out.println(card);
        }

        System.out.printf("Всего карт: %d", deck.size());
    }
}