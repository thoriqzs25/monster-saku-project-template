package com.monstersaku.util;

import com.monstersaku.Monsters.*;
import com.monstersaku.Player.Player;
import com.monstersaku.Moves.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* Nge Random dari MonsterPool untuk Player */

public class AddListMonster {

    public static void AddMonsters(Player player, List<Monster> monsterPool, List<Move> movePool) {
        List<Monster> monsss = new ArrayList<Monster>();
        List<Monster> monsterlistfull = monsterPool;

        for (int i = 0; i < 6; i++) { // Akan mendapatkan 6 random monster
            Collections.shuffle(monsterlistfull);
            Monster fromPoll = monsterlistfull.get(0);
            Monster tmpMonster = new Monster(fromPoll);
            int[] arrayMove = new int[fromPoll.getMoves().size()];

            List<Move> moves = fromPoll.getMoves();
            int j = 0;
            for (Move move : moves) {
                arrayMove[j] = move.getId();
                j++;
            }
            AddListMove.add(tmpMonster, arrayMove, movePool);
            monsss.add(tmpMonster);
        }

        player.setMonsters(monsss);
    }
}