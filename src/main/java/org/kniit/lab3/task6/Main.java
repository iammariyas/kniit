package org.kniit.lab3.task6;

public class Main {
    public static void main(String[] args) {
        Warrior warrior1 = new Warrior("Воин 1");
        Warrior warrior2 = new Warrior("Воин 2");
        WarriorGuard guard = new WarriorGuard("Танк");
        Mage mage = new Mage("Маг");
        Priest priest = new Priest("Целитель");

        System.out.println(warrior1);
        System.out.println("------------");
        System.out.println(warrior2);
        System.out.println("------------");
        System.out.println(guard);
        System.out.println("------------");
        System.out.println(mage);
        System.out.println("------------");
        System.out.println(priest);
        System.out.println("------------");

        System.out.println("\n------------\n");
        guard.boostWarrior(warrior1);
        mage.attack(warrior1);
        mage.attack(warrior2);
        priest.heal(warrior2);
        warrior2.attack(mage);
        warrior1.attack(mage);
        mage.attack(priest);
        guard.attack(mage);
        warrior1.attack(mage);
        System.out.println("\n------------\n");

        System.out.println(warrior1);
        System.out.println("------------");
        System.out.println(warrior2);
        System.out.println("------------");
        System.out.println(guard);
        System.out.println("------------");
        System.out.println(mage);
        System.out.println("------------");
        System.out.println(priest);
        System.out.println("------------");
    }
}
