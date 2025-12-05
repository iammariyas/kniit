package org.kniit.lab9.task17;

import java.lang.reflect.Field;

public class Validator {
    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            //разрешает доступ к private переменным
            field.setAccessible(true);
            Object value = field.get(obj);

            // Проверка @NotNull
            if (field.isAnnotationPresent(NotNull.class) && value == null) {
                System.out.println("Поле " + field.getName() + " не должно быть null.");
            }

            // Проверка @MaxLength
            if (field.isAnnotationPresent(MaxLength.class) && value instanceof String) {
                int max = field.getAnnotation(MaxLength.class).value();
                if (((String) value).length() > max) {
                    System.out.println("Поле " + field.getName() + " превышает максимальную длину " + max);
                }
            }

            // Проверка @Min
            if (field.isAnnotationPresent(Min.class) && value instanceof Integer) {
                int min = field.getAnnotation(Min.class).value();
                if ((Integer) value < min) {
                    System.out.println("Поле " + field.getName() + " должно быть не меньше " + min);
                }
            }
        }
    }
}
