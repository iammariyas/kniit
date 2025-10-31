package org.kniit.lab3.task6;

public class Priest extends Player implements Heallers {
    private int manaPriest;

    public Priest(String name) {
        super(name, 60, 20, 5);
        this.manaPriest = 60;
    }

    @Override
    public void heal(Player player) {
        if (!isFlagLife()) {
            System.out.printf("%s мертв и не может лечить\n", getName());
        }
        if (!player.isFlagLife()) {
            System.out.println("Персонаж, которого вы хотите вылечить мертв");
        }

        player.increaseHp(15);
        this.manaPriest -= 20;

        if (manaPriest < 15) {
            System.out.println("Нужно восстановиться!");
        }
    }
}
