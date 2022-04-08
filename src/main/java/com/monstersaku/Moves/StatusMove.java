package com.monstersaku.Moves;

import com.monstersaku.util.ElementType;
import com.monstersaku.util.Effect;
import com.monstersaku.Monsters.Monster;
import com.monstersaku.Status.Stats;

public class StatusMove extends Move {

    public StatusMove() {
        super();
    }

    public StatusMove(int id, String moveType, String name, ElementType elementType, int accuracy, int priority,
            int ammunition, String target, Effect effect) {
        setMove(id, moveType, name, elementType, accuracy, priority, ammunition, target, effect);
    }

    public void buffSelf(Monster self) {
        double d100 = 100;
        Effect effect = getEffect();
        Stats baseStats = self.getBaseStats();
        Stats currentStats = self.getCurrentStats();
        double healthBuff;

        if (effect.getHealthPoint() != 0) {
            healthBuff = baseStats.getHealthPoint() * (effect.getHealthPoint() / d100);
            double healthPoint = currentStats.getHealthPoint() + healthBuff;
            self.getCurrentStats().setHealthPoint(healthPoint);
        }
        double attack = Effect.convertedToFactorBuff(baseStats.getAttack(), effect.getAttack());
        double defense = Effect.convertedToFactorBuff(baseStats.getDefense(), effect.getDefense());
        double specialAttack = Effect.convertedToFactorBuff(baseStats.getSpecialAttack(), effect.getSpecialAttack());
        double specialDefense = Effect.convertedToFactorBuff(baseStats.getSpecialDefense(), effect.getSpecialDefense());
        double speed = Effect.convertedToFactorBuff(baseStats.getSpeed(), effect.getSpeed());
        self.getCurrentStats().setWithOutHealthPoint(attack, defense, specialAttack, specialDefense, speed);

    }

    public void debuffEnemy(Monster enemy) {
        Effect effect = getEffect();
        Stats baseStats = enemy.getBaseStats();

        double attack = Effect.convertedToFactorBuff(baseStats.getAttack(), effect.getAttack());
        double defense = Effect.convertedToFactorBuff(baseStats.getDefense(), effect.getDefense());
        double specialAttack = Effect.convertedToFactorBuff(baseStats.getSpecialAttack(), effect.getSpecialAttack());
        double specialDefense = Effect.convertedToFactorBuff(baseStats.getSpecialDefense(), effect.getSpecialDefense());
        double speed = Effect.convertedToFactorBuff(baseStats.getSpeed(), effect.getSpeed());
        enemy.getCurrentStats().setWithOutHealthPoint(attack, defense, specialAttack, specialDefense, speed);

    }

    public void applyMove(Monster self, Monster enemy) {
        // If self monster's is actually already died on the round
        if (self.getBaseStats().getHealthPoint() < 1) {
            System.out.println("Your monster had died earlier, proceed to next round!!");
        } else {
            if (getAmmunition() > 0) {
                String target = getTarget();
                if (target.equals("OWN")) {
                    buffSelf(self);
                } else if (target.equals("ENEMY")) {
                    debuffEnemy(enemy);
                }
                setAmmunition(getAmmunition() - 1);
            } else {
                System.out.println("Ammunition sudah habis, tidak bisa menggunakan " + getName());
            }
        }
    }
}
