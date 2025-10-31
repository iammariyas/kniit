package org.kniit.lab3.task6;

public abstract class Player {
    private final String name;
    private int hp;
    int fullHp;
    private boolean flagLife;
    private int x;
    private int y;
    int damage;
    int defense;

    public Player(String name, int fullHp, int damage, int defense) {
        this.name = name;
        this.fullHp = fullHp;
        this.hp = fullHp;
        this.damage = damage;
        this.defense = defense;
        this.flagLife = true;
        this.x = 0;
        this.y = 0;
    }

    public void increaseHp(int value) {
        if (!flagLife) {
            System.out.println("Персонаж уже мертв, мы не можем увеличить ему здоровье");
        } else {
            int tmp = hp;
            hp = Math.min(value + hp, fullHp);
            int healed = hp - tmp;
            System.out.printf("%s восстановил %s hp. Текущее здоровье %s\n", name, healed, hp);
        }
    }

    public void reduceHp(int value) {
        if (!flagLife) {
            System.out.println("Персонаж мертв, уменьшать здоровье ему не к чему");
        } else {
            int curDamge = Math.max(0, value - defense);
            hp -= curDamge;
            System.out.printf("\n%s уменьшил %s hp. Текущее здоровье: %s\n", name, curDamge, hp);
            if (hp <= 0) {
                flagLife = false;
                System.out.printf("%s умер\n", name);
            }
        }
    }

    public void position(int pos_x, int pos_y) {
        if (!flagLife) {
            System.out.printf("%s мертв, он не двигается", name);
        } else {
            x = pos_x;
            y = pos_y;
            System.out.printf("%s подвинулся на позицию %s и %s", name, (x + pos_x), (y + pos_y));
        }
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getFullHp() {
        return fullHp;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public boolean isFlagLife() {
        return flagLife;
    }
    @Override
    public String toString() {
        return String.format("""
                        Персонаж: %s
                        Текущее здоровье: %s
                        Максимальное здоровье: %s
                        Статус жизни: %s
                        Урон: %s
                        Защита: %s""",
                name, hp, fullHp, flagLife ? "живой" : "мертвый", getDamage(), getDefense());
    }

}