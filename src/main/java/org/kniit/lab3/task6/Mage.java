package org.kniit.lab3.task6;

public class Mage extends Player implements SpellAttack {
    private int spell;
    private int mana;

    public Mage(String name) {
        super(name, 80, 30, 15);
        this.spell = 30;
        this.mana = 70;
    }

    @Override
    public void attack(Player player) {
        if (!isFlagLife()) {
            System.out.printf("%s мертвый, он не может атаковать\n", getName());
            return;
        }
        if (!player.isFlagLife()) {
            System.out.printf("Лежачего не бьют. %s мертв\n", player.getName());
            return;
        }

        player.reduceHp(spell);
        if (player.getHp() == 0) {
            System.out.printf("%s умер", getName());
        }
        this.mana -= 20;

        if (mana < 20) {
            System.out.printf("%s не может атаковать пока не восстановится", getName());
        }
    }
}
