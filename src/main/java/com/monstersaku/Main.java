package com.monstersaku;

import com.monstersaku.Moves.*;
import com.monstersaku.Monsters.*;
import com.monstersaku.Status.Stats;

import com.monstersaku.util.*;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Main {
    // private static final List<String> CSV_FILE_PATHS =
    // Collections.unmodifiableList(Arrays.asList(
    // "configs/monsterpool.csv",
    // "configs/movepool.csv",
    // "configs/element-type-effectivity-chart.csv"));
    private static String fileName = "configs/movepool.csv";

    public static void main(String[] args) {

        List<Move> movePool = new ArrayList<Move>();
        movePool = CreateObjectMovePool.create();
        int[] tes = { 2, 3 };

        Stats baseStats = new Stats(100, 100, 100, 100, 100, 100);
        Stats currentStats = new Stats(100, 100, 100, 100, 100, 100);
        List<ElementType> elementTypes = new ArrayList<ElementType>();
        elementTypes.add(ElementType.FIRE);
        Monster gw = new Monster(1, "Aufa", elementTypes, baseStats, currentStats);
        AddListMove.add(gw, tes, movePool);
        for (Move move : gw.getMoves()) {
            move.printDetailMove();
        }

        // Stats baseStatsM = new Stats(100, 100, 100, 100, 100, 100);
        // Stats currentStatsM = new Stats(100, 100, 100, 100, 100, 100);
        // List<ElementType> elementTypesM = new ArrayList<ElementType>();
        // elementTypesM.add(ElementType.WATER);
        // Monster mimic = new Monster(1, "Mimic", elementTypesM, baseStatsM,
        // currentStatsM);

        // // Try Move Class
        // DefaultMove df = new DefaultMove();

        // Effect effectNM = new Effect(120);
        // NormalMove nm = new NormalMove(1, "NORMAL", "Punch", ElementType.NORMAL, 90,
        // 1, 10, "ENEMY", effectNM);

        // SpecialMove sm = new SpecialMove();
        // Effect effectSM = new Effect(120);
        // sm.setMove(2, "SPECIAL", "Special Punch", ElementType.NORMAL, 90, 1, 10,
        // "ENEMY", effectSM);

        // int[] statsBuff = { 0, 0, -1, 0, -1, 0 };
        // Effect effectSTM = new Effect(statsBuff);
        // StatusMove stm = new StatusMove(5, "STATUS", "Taunting", ElementType.NORMAL,
        // 90, 1, 10, "ENEMY", effectSTM);

        // System.out.println("##################");
        // System.out.println("TRY STATUS MOVE");
        // stm.applyMove(gw, mimic);
        // mimic.getCurrentStats().printDetailStats();
        // System.out.println("##################");
        // System.out.println("TRY SPECIAL MOVE");
        // mimic.getCurrentStats().printDetailStats();
        // sm.applyMove(gw, mimic);
        // mimic.getCurrentStats().printDetailStats();

    }

    // for (String fileName : CSV_FILE_PATHS) {
    // try {
    // System.out.printf("Filename: %s\n", fileName);
    // CSVReader reader = new CSVReader(new
    // File(Main.class.getResource(fileName).toURI()), ";");
    // reader.setSkipHeader(true);
    // List<String[]> lines = reader.read();
    // System.out.println("=========== CONTENT START ===========");
    // for (String[] line : lines) {
    // for (String word : line) {
    // System.out.printf("%s ", word);
    // }
    // System.out.println();
    // }
    // System.out.println("=========== CONTENT END ===========");
    // System.out.println();
    // } catch (Exception e) {
    // // do nothing
    // }
    // }
    // }
}
