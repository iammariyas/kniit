package org.kniit.lab11.task24;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAOImpl();
    }

    public void registerUser(String name, String email) throws SQLException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым!");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Эмейл не может быть пустым!");
        }

        if (userDAO.emailExists(email)) {
            throw new IllegalArgumentException("Этот эмейл уже существует: " + email);
        }
        User user = new User(name, email);
        userDAO.create(user);
        System.out.println("Пользователь успешно добавлен!");
    }

    public List<User> listAllUsers() throws SQLException {
        return userDAO.findAll();
    }

    public void deleteUser(int id) throws SQLException {
        User user = userDAO.findById(id);
        if (user == null) {
            throw new IllegalArgumentException("Пользователь " + id + " не найден");
        }
        userDAO.delete(id);
        System.out.println("Пользователь удален");
    }

    public void updateUser(int id, String newName, String newEmail) throws SQLException {
        User user = userDAO.findById(id);
        if (user == null) {
            throw new IllegalArgumentException("Пользователь " + id + " не найден");
        }
        if (newName == null || newName.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым!");
        }
        if (newEmail == null || newEmail.trim().isEmpty()) {
            throw new IllegalArgumentException("Эмейл не может быть пустым!");
        }
        boolean isEmailExists = userDAO.emailExists(newEmail);
        if (isEmailExists) {
            throw new IllegalArgumentException("Этот эмейл уже используется " + newEmail);
        }
        user.setName(newName);
        user.setEmail(newEmail);
        userDAO.update(user);
        System.out.println("Пользователь обновлен успешно");
    }
}