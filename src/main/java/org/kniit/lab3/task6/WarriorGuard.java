package org.kniit.lab3.task6;

public class WarriorGuard extends Warrior implements Attack {
    private final int damagePlayer;
    private final int defensePlayer;
    private int power;

    public WarriorGuard(String name) {
        super(name);
        this.damagePlayer = 15;
        this.defensePlayer = 30;
        this.power = 100;

    }

    public void boostWarrior(Warrior warrior) {
        if (!isFlagLife()) {
            System.out.printf("%s мертвый\n", getName());
        }
        if (!warrior.isFlagLife()) {
            System.out.printf("%s мертвый, ему защита не поможет\n", warrior.getName());
        }

        int guard = warrior.getDefense() + defensePlayer;
        System.out.printf("%s увеличил защиту %s, текущая защита: %s", getName(), warrior.getName(), guard);
    }

    @Override
    public void attack(Player player) {
        if (!isFlagLife()) {
            System.out.printf("%s мертвый, не может атаковапть\n", getName());
            return;
        }
        if (!player.isFlagLife()) {
            System.out.printf("%s уже мертвый\n", player.getName());
            return;
        }

        int trauma = getDamage() + damagePlayer;
        player.reduceHp(trauma);

        if (player.getHp() == 0) {
            System.out.printf("%s умер", getName());
        }
        power -= 10;

        if (power < 10) {
            System.out.println("Нужно восстановиться");
        }
    }

    @Override
    public int getDamage() {
        return damagePlayer;
    }

    @Override
    public int getDefense() {
        return defensePlayer;
    }
}
