package org.kniit.lab6.task10;

import java.util.*;

public class Hangman {
    public static final int LIVES = 6;
    public static Scanner scanner = new Scanner(System.in);
    private String randomWord;
    private StringBuilder maskedWord;
    private Set<Character> usedLetters;
    private int tries;
    private boolean isWin;

    public Hangman(String[] words) {
        this.randomWord = words[(int) (Math.random() * words.length)].toUpperCase();
        this.maskedWord = new StringBuilder(randomWord.replaceAll(".", "_"));
        this.usedLetters = new HashSet<>();
        this.tries = 0;
    }

    public boolean isWin() {
        return new String(maskedWord).equals(randomWord);
    }

    public boolean isLost() {
        return tries >= LIVES;
    }

    public boolean processLetter(char letter) {
        if (usedLetters.contains(letter)) {
            System.out.println("Эта буква уже была введена");
            return true;
        }
        usedLetters.add(letter);
        boolean found = false;
        for (int i = 0; i < randomWord.length(); i++) {
            if (randomWord.charAt(i) == letter) {
                maskedWord.setCharAt(i, letter);
                found = true;
            }
        }
        if (!found) {
            tries++;
            System.out.printf("Такой буквы нет. Осталось попыток: %d\n", (LIVES - tries));
        }
        return found;
    }

    public void display() {
        System.out.println(String.valueOf(randomWord));
        System.out.println(String.valueOf(maskedWord));
        System.out.println("Использованные буквы: ");
        usedLetters.forEach(ch -> System.out.println(ch + " "));
        System.out.println(maskedWord);
        System.out.println();
    }

    public String getRandomWord() {
        return randomWord;
    }
}


