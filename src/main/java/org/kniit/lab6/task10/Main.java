package org.kniit.lab6.task10;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static File file = new File("misc/", "file.txt");
    public static Scanner scanner = new Scanner(System.in);

    private static char inputLetter() {
        while (true) {
            String input = scanner.next().toUpperCase().trim();
            if (input.isEmpty() || !input.matches("[А-ЯЁ]")) {
                System.out.println("Ошибка. Введите русскую букву");
            }
            return input.charAt(0);
        }
    }

    private static String[] getWords(File file) {
        String[] words;
        StringBuilder result = new StringBuilder();
        try (Reader reader = new InputStreamReader(new FileInputStream(file))) {
            int a = reader.read();
            while (a > 0) {
                result.append((char) a);
                a = reader.read();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return words = result.toString().split("\n");
    }

    private static void questionPlayer() {
        System.out.println("Вы хотите начать игру?");
        System.out.println("Д - да, Н - нет");
        char answer = inputLetter();
        if (answer == 'Д') {
            startGame();
        } else if (answer == 'Н') {
            scanner.close();
            System.out.println("Вы завершили игру");
        } else {
            System.out.println("Введите Д или Н");
            questionPlayer();
        }
    }

    private static void startGame() {
        String[] words = getWords(file);
        Hangman game = new Hangman(words);

        System.out.println("Загаданное слово: ");
        game.display();

        while (!game.isWin() && !game.isLost()) {
            System.out.println("Введите букву: ");
            char letter = inputLetter();
            game.processLetter(letter);
            game.display();

            if (game.isWin()) {
                System.out.println("Вы угадали загаданное слово!");
                break;
            } else if (game.isLost()) {
                System.out.printf("Вы проиграли :(. Вы не отгадали слово: %s\n", game.getRandomWord());
                break;
            }
        }
        questionPlayer();
    }

    public static void main(String[] args) {
        questionPlayer();
    }
}