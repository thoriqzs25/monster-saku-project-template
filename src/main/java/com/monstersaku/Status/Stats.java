package com.monstersaku.Status;

public class Stats {
    private double healthPoint;
    private double attack;
    private double defense;
    private double specialAttack;
    private double specialDefense;
    private double speed;

    public Stats() {
    }

    public Stats(double healthPoint, double attack, double defense, double specialAttack, double specialDefense,
            double speed) {
        this.healthPoint = healthPoint;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }

    // All Getter Method
    public double getHealthPoint() {
        return healthPoint;
    }

    public double getAttack() {
        return attack;
    }

    public double getDefense() {
        return defense;
    }

    public double getSpecialAttack() {
        return specialAttack;
    }

    public double getSpecialDefense() {
        return specialDefense;
    }

    public double getSpeed() {
        return speed;
    }

    // All Setter Method
    public void setHealthPoint(double healthPoint) {
        this.healthPoint = healthPoint;
    }

    public void setWithOutHealthPoint(double attack, double defense, double specialAttack,
            double specialDefense,
            double speed) {
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }

    public void printDetailStats() {
        System.out.println("healthPoint: " + healthPoint);
        System.out.println("attack: " + attack);
        System.out.println("defense: " + defense);
        System.out.println("specialAttack: " + specialAttack);
        System.out.println("specialDefense: " + specialDefense);
        System.out.println("speed: " + speed);
    }
}
