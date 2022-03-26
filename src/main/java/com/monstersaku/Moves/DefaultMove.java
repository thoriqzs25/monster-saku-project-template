package com.monstersaku.Moves;

import com.monstersaku.util.ElementType;
import com.monstersaku.util.Effect;
import com.monstersaku.Monsters.Monster;
import com.monstersaku.Status.Stats;

public class DefaultMove extends Move {

    public DefaultMove() {
        Effect effect = new Effect(50);
        setMove(0, "NORMAL", "DefaulMove", ElementType.NORMAL, 100, 0, 99, "ENEMY", effect);
    }

    public void applyMove(Monster self, Monster enemy) {
        // Enemy
        double damage = damageCalculation(self, enemy);
        Stats currentStats = enemy.getCurrentStats();
        double updateHP = currentStats.getHealthPoint() - damage;
        currentStats.setHealthPoint(updateHP);
        enemy.setCurrentStats(currentStats);

        // Self
        Stats baseStatsSelf = self.getBaseStats();
        Stats currentStatsSelf = self.getCurrentStats();
        double updateHPSelf = baseStatsSelf.getHealthPoint() * 3 / 4;
        currentStatsSelf.setHealthPoint(updateHPSelf);
        self.setCurrentStats(currentStatsSelf);

    }

}
