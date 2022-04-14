package com.monstersaku.Moves;

import com.monstersaku.util.ElementType;
import com.monstersaku.util.Effect;
import com.monstersaku.Monsters.Monster;
import com.monstersaku.Status.Stats;

public class DefaultMove extends Move {

    public DefaultMove() {
        Effect effect = new Effect(50);
        setMove(0, "DEFAULT", "DefaultMove", ElementType.NORMAL, 100, 0, 99, "ENEMY", effect);
    }

    public void applyMove(Monster self, Monster enemy) {
        // If self monster's is actually already died on the round
        if (self.getBaseStats().getHealthPoint() < 1) {
            System.out.println("Your monster had died earlier, proceed to next round!!");
        } else {
            if (getAmmunition() > 0) {
                // Enemy
                double damage = damageCalculation(self, enemy);
                Stats currentStats = enemy.getCurrentStats();
                double updateHP = currentStats.getHealthPoint() - damage;
                if (updateHP <= 0) {
                    updateHP = 0;
                }
                currentStats.setHealthPoint(updateHP);
                enemy.setCurrentStats(currentStats);

                // Self
                Stats baseStatsSelf = self.getBaseStats();
                Stats currentStatsSelf = self.getCurrentStats();
                double updateHPSelf = baseStatsSelf.getHealthPoint() * 3 / 4;
                currentStatsSelf.setHealthPoint(updateHPSelf);
                if (updateHPSelf <= 0) {
                    updateHPSelf = 0;
                }
                self.setCurrentStats(currentStatsSelf);

            } else {
                System.out.println("Ammunition sudah habis, tidak bisa menggunakan " + getName());
            }
        }
    }
}
