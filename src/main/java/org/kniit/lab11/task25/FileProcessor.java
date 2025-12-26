package org.kniit.lab11.task25;

import java.io.File;

import static org.kniit.lab11.task25.FileDAO.saveFile;

public class FileProcessor {
    private static final long MAX_SIZE = 10 * 1024 * 1024; // 10MB

    private void processSingleFile(File file) {
        if (file.length() < MAX_SIZE) {
            try {
                saveFile(file);
                System.out.printf("Сохранен: %s\n", file.getName());
            } catch (Exception e) {
                System.err.println("Ошибка! " + e.getMessage());
            }
        } else {
            System.out.printf("Файл больше 10МБ %s\n", file.getName());
        }
    }

    private void processDirectory(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                processSingleFile(file);
            }
        }
    }

    public void processFiles(String path) {
        File target = new File(path);
        if (target.isFile()) {
            processSingleFile(target);
        } else if (target.isDirectory()) {
            processDirectory(target);
        }
    }
}
