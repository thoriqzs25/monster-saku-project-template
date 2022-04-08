package com.monstersaku.Monsters;

import com.monstersaku.Status.Stats;
import com.monstersaku.Moves.Move;
import com.monstersaku.util.ElementType;
import com.monstersaku.util.Effect;
import com.monstersaku.Player.*;

import com.monstersaku.util.CSVReader;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Monster {
    private int id;
    private String name;
    private List<ElementType> elementTypes;
    private Stats baseStats;
    private Stats currentStats;
    private List<Move> moves;
    private String statusCondition;

    public Monster() {

    }

    public Monster(int id, String name, List<ElementType> elementTypes, Stats baseStats, Stats currentStats) {
        this.id = id;
        this.name = name;
        this.elementTypes = elementTypes;
        this.baseStats = baseStats;
        this.currentStats = currentStats;
        statusCondition = "-";
    }

    public Monster(int id, String name, List<ElementType> elementTypes, Stats baseStats, Stats currentStats,
            String statusCondition) {
        this.id = id;
        this.name = name;
        this.elementTypes = elementTypes;
        this.baseStats = baseStats;
        this.currentStats = currentStats;
        this.statusCondition = statusCondition;
    }

    public Monster(int id, String name, List<ElementType> elementTypes, Stats baseStats, Stats currentStats,
            List<Move> moves, String statusCondition) {
        this.id = id;
        this.name = name;
        this.elementTypes = elementTypes;
        this.baseStats = baseStats;
        this.currentStats = currentStats;
        this.moves = moves;
        this.statusCondition = statusCondition;
    }

    // All Getter Method
    public String getName() {
        return this.name;
    }

    public Stats getBaseStats() {
        return baseStats;
    }

    public Stats getCurrentStats() {
        return currentStats;
    }

    public List<ElementType> getElementTypes() {
        return elementTypes;
    }

    public String getStatusCondition() {
        return statusCondition;
    }

    public List<Move> getMoves() {
        return moves;
    }

    // All Setter Method
    public void setCurrentStats(Stats currentStats) {
        this.currentStats = currentStats;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void outputMonster() {
        System.out.println("----- IDENTITAS MONSTER -----");
        System.out.printf("ID Monster   : %d \n", this.id);
        System.out.printf("Nama Monster : %s \n", this.name);
        System.out.printf("Element Types: ");
        System.out.println(Arrays.toString(elementTypes.toArray()));
    }

    public boolean isMonsterAlive() {
        if (currentStats.getHealthPoint() != 0) {
            return true;
        } else {
            return false;
        }
    }

    // Use monster to play
    public void play(Scanner scan, Player player) {
        // Array of id's of the owned move by the current monster
        List<Integer> listId = new ArrayList<Integer>();
        for (Move m : moves) {
            listId.add(m.getId());
        }

        // Validate if move id is available
        int cmd = -999;
        while (!listId.contains(cmd)) {
            System.out.printf("Pick a move : ");
            cmd = scan.nextInt();
            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i).getId() == cmd) {
                    System.out.printf("User picked %s\n", moves.get(i).getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("System failed to sleep");
                    }
                    player.setCurrentMove(moves.get(i));
                }
            }
        }
    }
}