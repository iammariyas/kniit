package org.kniit.lab5.task9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Keyboard {
    public static List<String> getWords(String path) {
        List<String> words = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNext()) {
                words.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.printf("Файл %s не найден", path);
        }
        return words;
    }

    public static void main(String[] args) {
        List<String> words = getWords("misc/dictionary.txt");
        if (words.isEmpty()) {
            System.out.println("Список слов пустой!");
        }

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int allWords = 0, correctWords = 0, chars = 0;
        Timer timer = new Timer(60);
        timer.start();

        System.out.println("Время пошло");

        while (!timer.isTime()) {
            if (timer.isTime()) {
                break;
            }

            String target = words.get(random.nextInt(words.size()));
            System.out.printf("Осталось %d секунд. Введите слово %s ", timer.getSeconds(), target);
            String userInput = scanner.nextLine();

            if (timer.isTime()) {
                break;
            }

            allWords++;
            chars += userInput.length();
            if (userInput.equals(target)) {
                correctWords++;
            }
        }

        System.out.println("Время вышло");
        System.out.printf("Количество слов всего было: %s", allWords);
        System.out.printf("\nколичество правильных слов: %s", correctWords);
        System.out.printf("\nколичество введенных символов: %s", chars);
        System.out.printf("\nскорость символов в секунду: %s", chars / 60.0);
    }
}
