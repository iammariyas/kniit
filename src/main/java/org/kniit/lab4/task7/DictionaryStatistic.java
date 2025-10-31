package org.kniit.lab4.task7;

import java.util.*;

public class DictionaryStatistic {
    private String[] words;
    private int dictionarySize; // Количество слов
    private int palindrome; // Количество слов полиндромов
    private int maxWordLength; // маскимальная длина слова в словаре
    private int minWordLength; // минимальная длина слова в словаре
    private char[] alphabet; // буквы алфавита

    public DictionaryStatistic(String[] words, char[] alphabet) {
        this.words = words;
        this.alphabet = alphabet;
    }

    public int getDictionarySize() {
        return words.length;
    }

    public int getPalindrome() {
        return palindrome;
    }

    boolean isPalindrome(String word) {
        String lower = word.toLowerCase();
        int length = lower.length();
        for (int i = 0; i < (length / 2); i++) {
            if (lower.charAt(i) != lower.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    void calcPalindrome() {
        palindrome = 0;
        for (String word: words) {
            if (isPalindrome(word)) {
                palindrome++;
            }
        }
    }

    public int getMaxWordLength() {
        return maxWordLength;
    }

    public int getMinWordLength() {
        return minWordLength;
    }

    void calcWordLength() {
        if (words.length == 0) {
            maxWordLength = 0;
            minWordLength = 0;
        }

        List<Integer> lenWord = new ArrayList<>();
        for (String word: words) {
            lenWord.add(word.length());
        }

        maxWordLength = Collections.max(lenWord);
        minWordLength = Collections.min(lenWord);
    }


    public String getRandomWord() {
        Random rnd = new Random();
        int i = rnd.nextInt(words.length);
        return words[i];
    }

    public void printSymbolsStat() {
        HashMap<Character, Integer> counter = new HashMap<>();
        for (String word: words) {
            for (char i: word.toLowerCase().toCharArray()) {
                if (Character.isLetter(i)) {
                    counter.put(i, counter.getOrDefault(i, 0) + 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry: counter.entrySet()) {
            System.out.printf("'%s': %s\n", entry.getKey(), entry.getValue());
        }
    }
}
