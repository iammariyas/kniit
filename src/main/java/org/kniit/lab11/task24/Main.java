package org.kniit.lab11.task24;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final UserService userService = new UserService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showHelp();

        while (true) {
            System.out.print("\nВведите команду: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }
            String[] parts = input.split("\\s+", 4);
            String command = parts[0].toLowerCase();
            try {
                switch (command) {
                    case "add" -> handleAdd(parts);
                    case "list" -> handleList();
                    case "delete" -> handleDelete(parts);
                    case "update" -> handleUpdate(parts);
                    case "help" -> showHelp();
                    case "exit" -> {
                        System.out.println("До свидания!");
                        DatabaseConnection.closeConnection();
                        return;
                    }
                    default -> System.out.println("Неизвестная команда.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Ошибка базы данных: " + e.getMessage());
            }
        }
    }

    private static void handleAdd(String[] parts) throws SQLException {
        if (parts.length < 3) {
            System.out.println("Используйте: add [name] [email]");
            return;
        }
        String name = parts[1];
        String email = parts[2];
        userService.registerUser(name, email);
    }

    private static void handleList() throws SQLException {
        List<User> users = userService.listAllUsers();
        if (users.isEmpty()) {
            System.out.println("Ни одного пользователя не найдено.");
        } else {
            System.out.println("\nСписок пользователей:");
            System.out.println("--------------");
            for (User user : users) {
                System.out.println(user);
            }
            System.out.printf("Количество пользователей: %s", users.size());
        }
    }

    private static void handleDelete(String[] parts) throws SQLException {
        if (parts.length < 2) {
            System.out.println("Используйте: delete [id]");
            return;
        }
        try {
            int id = Integer.parseInt(parts[1]);
            userService.deleteUser(id);
        } catch (NumberFormatException e) {
            System.out.println("id должен быть числом!");
        }
    }

    private static void handleUpdate(String[] parts) throws SQLException {
        if (parts.length < 4) {
            System.out.println("Используйте: update [id] [new_name] [new_email]");
            return;
        }
        try {
            int id = Integer.parseInt(parts[1]);
            String newName = parts[2];
            String newEmail = parts[3];
            userService.updateUser(id, newName, newEmail);
        } catch (NumberFormatException e) {
            System.out.println("id должен быть числом!");
        }
    }

    private static void showHelp() {
        System.out.println("\nДоступные команды:");
        System.out.println("\tadd [name] [email] - Добавить нового пользователя");
        System.out.println("\tlist - Список всех пользователей");
        System.out.println("\tdelete [id] - Удалить пользователя по id");
        System.out.println("\tupdate [id] [name] [email] - Обновить пользователя");
        System.out.println("\thelp - Показать эту подсказку");
        System.out.println("\texit - Завершить");
    }
}