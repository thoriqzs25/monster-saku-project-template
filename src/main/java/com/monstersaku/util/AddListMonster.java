package com.monstersaku.util;

import com.monstersaku.Monsters.*;
import com.monstersaku.Player.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* Nge Random dari MonsterPool untuk Player */

public class AddListMonster {

    public static void AddMonsters(Player player, List<Monster> monsterPool) {
        List<Monster> monsss = new ArrayList<Monster>();
        List<Monster> monsterlistfull = monsterPool;

        for (int i = 0; i < 6; i++) { // Akan mendapatkan 6 random monster
            Collections.shuffle(monsterlistfull);
            monsss.add(monsterlistfull.get(0));
        }

        player.setMonsters(monsss);
    }
}