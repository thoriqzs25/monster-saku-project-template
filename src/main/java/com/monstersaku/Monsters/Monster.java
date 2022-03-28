package com.monstersaku.Monsters;

import com.monstersaku.Status.Stats;
import com.monstersaku.Moves.Move;
import com.monstersaku.util.ElementType;
import com.monstersaku.util.Effect;

import com.monstersaku.util.CSVReader;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Monster {
    private int ID;
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
}
