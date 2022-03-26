package com.monstersaku;

import com.monstersaku.util.FindEffectivity;
import com.monstersaku.util.ElementType;
import com.monstersaku.Moves.*;
import com.monstersaku.Monsters.*;
import com.monstersaku.Status.Stats;

import com.monstersaku.util.CSVReader;
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
        Stats baseStats = new Stats(100, 100, 100, 100, 100, 100);
        Stats currentStats = new Stats(100, 100, 100, 100, 100, 100);
        List<ElementType> elementTypes = new ArrayList<ElementType>();
        elementTypes.add(ElementType.FIRE);
        Monster gw = new Monster(1, "Aufa", elementTypes, baseStats, currentStats);

        Stats baseStatsM = new Stats(100, 100, 100, 100, 100, 100);
        Stats currentStatsM = new Stats(100, 100, 100, 100, 100, 100);
        List<ElementType> elementTypesM = new ArrayList<ElementType>();
        elementTypesM.add(ElementType.FIRE);
        Monster mimic = new Monster(1, "Mimic", elementTypesM, baseStatsM, currentStatsM);

        DefaultMove df = new DefaultMove();
        mimic.getCurrentStats().printDetailStats();
        df.applyMove(gw, mimic);
        mimic.getCurrentStats().printDetailStats();

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
