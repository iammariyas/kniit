package org.kniit.lab9.task17;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User(null, "LongUsernameHere", 16);

        Validator.validate(user);
    }
}
