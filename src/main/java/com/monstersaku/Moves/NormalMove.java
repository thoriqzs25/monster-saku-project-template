package com.monstersaku.Moves;

import com.monstersaku.util.ElementType;
import com.monstersaku.util.Effect;
import com.monstersaku.Monsters.Monster;
import com.monstersaku.Status.Stats;

public class NormalMove extends Move {

    public NormalMove() {

    }

    public NormalMove(int id, String moveType, String name, ElementType elementType, int accuracy, int priority,
            int ammunition, String target, Effect effect) {
        setMove(id, moveType, name, elementType, accuracy, priority, ammunition, target, effect);
    }

    public void applyMove(Monster self, Monster enemy) {
        if (getAmmunition() > 0) {
            // Enemy
            double damage = damageCalculation(self, enemy);
            Stats currentStats = enemy.getCurrentStats();
            double updateHP = currentStats.getHealthPoint() - damage;
            currentStats.setHealthPoint(updateHP);
            enemy.setCurrentStats(currentStats);

        } else {
            System.out.println("Ammunition sudah habis, tidak bisa menggunakan " + getMoveName());
        }

    }
}
