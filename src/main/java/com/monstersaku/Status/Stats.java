package com.monstersaku.Status;

public class Stats {
    private double initialHealthPoint; // To track base HP of a monster
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

        // Track default stats of each monster
        initialHealthPoint = healthPoint;
    }

    public Stats(Stats stats) {
        setHealthPoint(stats.getHealthPoint());
        setAttack(stats.getAttack());
        setDefense(stats.getDefense());
        setSpecialAttack(stats.getSpecialAttack());
        setSpecialDefense(stats.getSpecialDefense());
        setSpeed(stats.getSpeed());
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

    public double getInitialHealthPoint() {
        return initialHealthPoint;
    }

    // All Setter Method
    public void setHealthPoint(double healthPoint) {
        this.healthPoint = healthPoint;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public void setSpecialAttack(double specialAttack) {
        this.specialAttack = specialAttack;
    }

    public void setSpecialDefense(double specialDefense) {
        this.specialDefense = specialDefense;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
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
