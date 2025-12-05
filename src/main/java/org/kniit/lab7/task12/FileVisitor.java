package org.kniit.lab7.task12;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

class WordCounter {
    private long allWords = 0;

    public static void main(String[] args) throws IOException {
        WordCounter counter = new WordCounter();
        Path startPath = Paths.get("src/main/java/org/kniit/lab7/task12/directory1");
        Files.walkFileTree(startPath, counter.new CustomFileVisitor());
        System.out.printf("Общее количество слов во всех текстовых файлах: %d", counter.allWords);
    }

    public class CustomFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().endsWith(".txt")) {
                List<String> lines = Files.readAllLines(file);
                long fileWords = 0;

                for (String line : lines) {
                    String[] words = line.split("[\\s\\p{Punct}]+");
                    fileWords += words.length;
                }
                System.out.printf("Файл: %s количество слов: %d \n", file.getFileName(), fileWords);
                allWords += fileWords;
            }
            return FileVisitResult.CONTINUE;
        }
    }
}