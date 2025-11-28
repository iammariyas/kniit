package org.kniit.lab6.task11;

import java.util.Scanner;
import java.util.TreeSet;

public class StudentList {
    private final Scanner scanner = new Scanner(System.in);
    private final TreeSet<Student> students = new TreeSet<>();

    private void print() {
        System.out.println("""
                \nМеню:
                1. Добавить студента
                2. Удалить студента
                3. Показать всех студентов
                4. Найти студента
                5. Найти студентов по диапазону
                6. Выйти
                
                Выберите опцию:
                """);
    }

    private void addStudent() {
        System.out.println("Введите ФИО студента: ");
        String name = scanner.nextLine().trim();

        Student student = new Student(name);
        if (students.contains(student)) {
            System.out.println("Такой студент уже есть");
        } else {
            students.add(student);
            System.out.println("Студент добавлен");
        }
    }

    private void deleteStudent() {
        System.out.println("Введите имя студента для удаления: ");
        String name = scanner.nextLine().trim();
        Student student = new Student(name);
        if (students.remove(student)) {
            System.out.println("Студент удален");
        } else {
            System.out.println("Студента с таким именем нет, удалять нечего");
        }
    }

    private void showStudents() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст");
        } else {
            System.out.println("Список студентов: ");
            students.forEach(System.out::println);
        }
    }

    private void findStudent() {
        System.out.println("Введите имя студента для поиска:");
        String name = scanner.nextLine().trim();

        Student student = new Student(name);
        if (students.contains(student)) {
            System.out.println("Студент найден");
        } else {
            System.out.println("Студент не найден");
        }
    }

    private void findRange() {
        System.out.println("Введите первого студента из списка: ");
        String start = scanner.nextLine().trim();

        System.out.println("Введите второго студента из списка: ");
        String end = scanner.nextLine().trim();

        Student studentStart = new Student(start);
        Student studentEnd = new Student(end);

        TreeSet<Student> studentRange = new TreeSet<>(students.subSet(studentStart, true, studentEnd, true));
        if (studentRange.isEmpty()) {
            System.out.println("Студенты в диапазоне не найдены");
        } else {
            System.out.println("Список студентов в диапазоне: ");
            studentRange.forEach(System.out::println);
        }
    }

    public void run() {
        while (true) {
            print();
            int ans = scanner.nextInt();
            scanner.nextLine();

            switch (ans) {
                case 1 -> addStudent();
                case 2 -> deleteStudent();
                case 3 -> showStudents();
                case 4 -> findStudent();
                case 5 -> findRange();
                case 6 -> {
                    System.out.println("До встречи!");
                    break;
                }
                default -> System.out.println("Попробуйте снова.");
            }
        }
    }
}
