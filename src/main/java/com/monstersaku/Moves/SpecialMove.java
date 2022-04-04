package com.monstersaku.Moves;

import com.monstersaku.util.ElementType;
import com.monstersaku.util.Effect;
import com.monstersaku.Monsters.Monster;
import com.monstersaku.Status.Stats;
import com.monstersaku.util.FindEffectivity;

import java.text.DecimalFormat;

public class SpecialMove extends Move {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public SpecialMove() {

    }

    public SpecialMove(int id, String moveType, String name, ElementType elementType, int accuracy, int priority,
            int ammunition, String target, Effect effect) {
        setMove(id, moveType, name, elementType, accuracy, priority, ammunition, target, effect);
    }

    public double damageCalculation(Monster self, Monster enemy) {
        // Get Power
        double power = getEffect().getAttack();

        // Get sourceSpecialAttack and targetSpecialDefense
        double sourceAttack = self.getCurrentStats().getSpecialAttack();
        double targetDefense = enemy.getCurrentStats().getSpecialDefense();

        // Get random(0.85, 1)
        double randomValue = Math.random() / 100 * 15 + 0.85;
        randomValue = Double.valueOf(df.format(randomValue));
        // System.out.println("random: " + randomValue);

        // Get Effectivity
        double elementEffectiviy = 1;
        ElementType elementType = getElementType();
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

    public void applyMove(Monster self, Monster enemy) {
        if (getAmmunition() > 0) {
            // Enemy
            double damage = damageCalculation(self, enemy);
            Stats currentStats = enemy.getCurrentStats();
            double updateHP = currentStats.getHealthPoint() - damage;
            currentStats.setHealthPoint(updateHP);
            enemy.setCurrentStats(currentStats);
            setAmmunition(getAmmunition() - 1);
        } else {
            System.out.println("Ammunition sudah habis, tidak bisa menggunakan " + getName());
        }
    }
}
