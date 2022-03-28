package com.monstersaku.Moves;

import com.monstersaku.util.ElementType;
import com.monstersaku.util.Effect;
import com.monstersaku.Monsters.Monster;
import com.monstersaku.util.FindEffectivity;

import java.text.DecimalFormat;

public abstract class Move {
    private int id;
    private String moveType;
    private String name;
    private ElementType elementType;
    private int accuracy;
    private int priority;
    private int ammunition;
    private String target;
    private Effect effect;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Move() {

    }

    public void setMove(int id, String moveType, String name, ElementType elementType, int accuracy, int priority,
            int ammunition,
            String target,
            Effect effect) {
        this.id = id;
        this.moveType = moveType;
        this.name = name;
        this.elementType = elementType;
        this.accuracy = accuracy;
        this.priority = priority;
        this.ammunition = ammunition;
        this.target = target;
        this.effect = effect;
    }

    public void copyMove(Move move) {
        setId(move.getId());
        setMoveType(move.getMoveType());
        setName(move.getName());
        setElementType(move.getElementType());
        setAccuracy(move.getAccuracy());
        setAmmunition(move.getAmmunition());
        setTarget(move.getTarget());
        setEffect(move.getEffect());
    }

    // Setter Attribute
    public void setId(int id) {
        this.id = id;
    }

    public void setMoveType(String moveType) {
        this.moveType = moveType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setAmmunition(int ammunition) {
        this.ammunition = ammunition;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    /* Getter Attribute */
    public int getId() {
        return id;
    }

    public String getMoveType() {
        return moveType;
    }

    public String getName() {
        return name;
    }

    public ElementType getElementType() {
        return elementType;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getPriority() {
        return priority;
    }

    public int getAmmunition() {
        return ammunition;
    }

    public String getTarget() {
        return target;
    }

    public Effect getEffect() {
        return effect;
    }

    public void printDetailMove() {
        System.out.println("id: " + id);
        System.out.println("moveType: " + getMoveType());
        System.out.println("name: " + getName());
        System.out.println("elementType: " + elementType.toString());
        System.out.println("accuracy: " + String.valueOf(accuracy));
        System.out.println("priority: " + String.valueOf(priority));
        System.out.println("ammunition: " + String.valueOf(ammunition));
        System.out.println("target: " + target);
        effect.printDetailEffect();
        System.out.println("###########");
    }

    public double damageCalculation(Monster self, Monster enemy) {
        // Get Power
        double power = effect.getAttack();

        // Get sourceAttack and targetDefense
        double sourceAttack = self.getCurrentStats().getAttack();
        double targetDefense = enemy.getCurrentStats().getDefense();

        // Get random(0.85, 1)
        double randomValue = Math.random() / 100 * 15 + 0.85;
        randomValue = Double.valueOf(df.format(randomValue));
        // System.out.println("random: " + randomValue);

        // Get Effectivity
        double elementEffectiviy = 1;
        for (ElementType enemyType : enemy.getElementTypes()) {
            elementEffectiviy = elementEffectiviy * FindEffectivity.getValue(elementType, enemyType);
        }

        // Get Burn
        double burn = 1;
        if (self.getStatusCondition() == "BURN") {
            burn = 0.5;
        }

        // Get Damage
        double damage = Math
                .floor((power * (sourceAttack / targetDefense) + 2) * randomValue * elementEffectiviy * burn);
        return damage;
    }

    public abstract void applyMove(Monster self, Monster enemy);

}