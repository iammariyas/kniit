package org.kniit.lab4.task7;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("misc/dictionary.txt"));
        ArrayList<String> wordLst = new ArrayList<>();

        while (scanner.hasNext()) {
            String word = scanner.nextLine();
            if (!word.isEmpty()) {
                wordLst.add(word);
            }
        }
        scanner.close();

        String[] words = wordLst.toArray(new String[0]);
        char[] alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
        DictionaryStatistic dictionaryStatistic = new DictionaryStatistic(words, alphabet);

        dictionaryStatistic.calcPalindrome();
        dictionaryStatistic.calcWordLength();
        dictionaryStatistic.printSymbolsStat();
        System.out.printf("Количество слов: %s\n", dictionaryStatistic.getDictionarySize());
        System.out.printf("Палиндромов: %s\n", dictionaryStatistic.getPalindrome());
        System.out.printf("Максимальная длина слова: %s\n", dictionaryStatistic.getMaxWordLength());
        System.out.printf("Минимальная длина слова: %s\n", dictionaryStatistic.getMinWordLength());
        System.out.printf("Случайное слово: %s\n", dictionaryStatistic.getRandomWord());
    }
}
