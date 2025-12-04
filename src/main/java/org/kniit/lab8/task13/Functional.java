package org.kniit.lab8.task13;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Functional {
    private final Scanner scanner = new Scanner(System.in);
    private List<User> users = new ArrayList<>();

    void saveUser(List<User> users, String name) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(name);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(users);
        objectOutputStream.flush();
    }

    List<User> loadUser(String name) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(name);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<User> users = (List<User>) objectInputStream.readObject();
        return users;
    }

    void menu() {
        System.out.println("""
                Добро пожаловать в систему управления пользователями!
                Выберите действие:
                1. Добавить нового пользователя
                2. Показать всех пользователей
                3. Сохранить список пользователей в файл
                4. Загрузить список пользователей из файла
                5. Выйти
                """);
    }

    void addUser() {
        System.out.println("Введите имя нового пользователя: ");
        String name = scanner.nextLine().trim();

        System.out.println("Введите возраст пользователя: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите почту пользователя: ");
        String email = scanner.nextLine().trim();

        User user = new User(name, age, email);
        if (!(users.contains(user))) {
            users.add(user);
        } else {
            System.out.println("Этот пользователь уже существует");
        }
    }

    void show() {
        if (users.isEmpty()) {
            System.out.println("Список пользователей пустой");
        } else {
            System.out.println("Список пользователей: ");
            users.forEach(System.out::println);
        }
    }

    void listInFile() {
        try {
            System.out.println("Введите имя файла: ");
            String file = scanner.nextLine().trim();

            if (users == null) {
                users = new ArrayList<>();
            }

            saveUser(users, file);
            System.out.printf("Список сохранен в файл: %s\n", file);
        } catch (IOException e) {
            System.out.println("Ошибка!" + e.getMessage());
        }
    }

    void loadList() {
        try {
            System.out.println("Введите имя файла для загрузки: ");
            String file = scanner.nextLine().trim();
            users = loadUser(file);
            System.out.println("Список успешно загружен из файла");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден. Начинаем с пустого списка");
            users = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    void program() {
        while (true) {
            menu();
            int ans = scanner.nextInt();
            scanner.nextLine();

            switch (ans) {
                case 1:
                    addUser();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    listInFile();
                    break;
                case 4:
                    loadList();
                    break;
                case 5: {
                    try {
                        if (!users.isEmpty()) {
                            System.out.println("Введите имя файла: ");
                            String file = scanner.nextLine().trim();

                            saveUser(users, file);
                            System.out.println("Данные сохранены");
                        }
                    } catch (IOException e) {
                        System.out.println("Ошибка сохранения: " + e.getMessage());
                    }
                    System.out.println("До встречи!");
                    return;
                }
            }
        }
    }
}
