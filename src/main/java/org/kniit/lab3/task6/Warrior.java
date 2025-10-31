package org.kniit.lab3.task6;

public class Warrior extends Player implements Attack {
    private int power;

    public Warrior(String name) {
        super(name, 100, 40, 10);
        this.power = 100;
    }

    @Override
    public void attack(Player player) {
        if (!isFlagLife()) {
            System.out.printf("%s мертвый, не может атаковапть\n", getName());
        }
        if (!player.isFlagLife()) {
            System.out.printf("%s уже мертвый\n", player.getName());
        }

        player.reduceHp(getDamage());
        if (player.getHp() == 0) {
            System.out.printf("%s умер", getName());
        }
        power -= 10;

        if (power < 10) {
            System.out.println("Нужно восстановиться");
        }
    }
}
