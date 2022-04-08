// INFOOO FIND "CAUTION!!!" di search vscode buat cek hal2 yang penting tapi belom dilakukan.

package com.monstersaku;

import com.monstersaku.Moves.*;
import com.monstersaku.Monsters.*;
import com.monstersaku.Status.Stats;
import com.monstersaku.Player.Player;

import com.monstersaku.util.*;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static final List<String> CSV_FILE_PATHS = Collections.unmodifiableList(Arrays.asList(
            "configs/monsterpool.csv",
            "configs/movepool.csv",
            "configs/element-type-effectivity-chart.csv"));

    public static void readConfig() {
        CreateObjectMonsterPool.setFileName(CSV_FILE_PATHS.get(0));
        CreateObjectMovePool.setFileName(CSV_FILE_PATHS.get(1));
        FindEffectivity.setFileName(CSV_FILE_PATHS.get(2));
    }

    public static void main(String[] args) {
        // CSV files configuration setup
        Scanner scan = new Scanner(System.in);
        readConfig();

        // Creating necessary objects
        List<Player> playerList = new ArrayList<Player>();
        List<Monster> monsterPool = CreateObjectMonsterPool.create();
        List<Move> movePool = CreateObjectMovePool.create();
        Display.loading(10);

        // Retrieving input type String from user
        String cmd = new String();
        while (true) {
            Display.showMenuAwal();
            cmd = scan.next();
            Display.cls(); // Clear screen

            // Identifying user input
            switch (cmd) {
                case "1":
                    // Input both player names
                    for (int i = 0; i < 2; i++) {
                        System.out.printf("Input player %d's name : ", i + 1);
                        Player player = new Player(new String(scan.next()));

                        // Give all player 6 monsters each and show their first monster to use
                        AddListMonster.AddMonsters(player, monsterPool);
                        System.out.printf("Registered first monster to use -> %s\n\n",
                                player.getCurrentMonster().getName());
                        playerList.add(player);
                    }
                    System.out.printf("Starting");
                    Display.loading(10);
                    Display.cls();

                    Game game = new Game(playerList, scan);
                    break;
                case "2":
                    Game.help();
                    break;
                case "3":
                    Game.exit();
                    break;
                default:
                    break;
            }
        }

        /*
         * List<Move> movePool = new ArrayList<Move>();
         * movePool = CreateObjectMovePool.create();
         * RandomGen.random(6);
         * 
         * // Stats baseStats = new Stats(100, 100, 100, 100, 100, 100);
         * // Stats currentStats = new Stats(100, 100, 100, 100, 100, 100);
         * // List<ElementType> elementTypes = new ArrayList<ElementType>();
         * // elementTypes.add(ElementType.FIRE);
         * // Monster gw = new Monster(1, "Aufa", elementTypes, baseStats,
         * currentStats);
         * // AddListMove.add(gw, tes, movePool);
         * // // for (Move move : gw.getMoves()) {
         * // // move.printDetailMove();
         * // // }
         * 
         * // Stats baseStatsI = new Stats(100, 100, 100, 100, 100, 100);
         * // Stats currentStatsI = new Stats(100, 100, 100, 100, 100, 100);
         * // List<ElementType> elementTypesI = new ArrayList<ElementType>();
         * // elementTypes.add(ElementType.WATER);
         * // Monster ima = new Monster(2, "Ima", elementTypesI, baseStatsI,
         * // currentStatsI);
         * // int[] movesIma = { 1, 4 };
         * // AddListMove.add(ima, movesIma, movePool);
         * // for (Move move : ima.getMoves()) {
         * // move.printDetailMove();
         * // }
         * 
         * 
         * Stats baseStatsI = new Stats(100, 100, 100, 100, 100, 100);
         * Stats currentStatsI = new Stats(100, 100, 100, 100, 100, 100);
         * List<ElementType> elementTypesI = new ArrayList<ElementType>();
         * elementTypes.add(ElementType.WATER);
         */
        // Masukkin mau berapa pemain yang ikut
        // Scanner inp = new Scanner(System.in);
        // System.out.println("");
        // int i;
        // List<Player> playerlist = new ArrayList<Player>();
        // for (i = 0; i < 2; i++) {
        // // pembuatan objek player
        // System.out.printf("Masukkan nama Player%d: ", i + 1);
        // String name = inp.next();
        // // pembacaan monster pool, pembagoan minster
        // List<Monster> myMonsters = CreateObjectMonsterPool.create();
        // /*
        // * System.out.println(Arrays.toString(myMonsters.toArray()));
        // * System.out.println(myMonsters.get(0).getName());
        // */
        // Player p = new Player(name, myMonsters);
        // playerlist.add(p);
        // playerlist.get(i).printMyMonster();
        // }
        // liat monster setiap pemain
        /*
         * for (int y = 0; y < 2; y++) {
         * playerlist.get(y).printMyMonster();
         * }
         */

        // inp.close();
        /*
         * Monster ima = new Monster(2, "Ima", elementTypesI, baseStatsI,
         * currentStatsI);
         * int[] movesIma = { 1, 4 };
         * AddListMove.add(ima, movesIma, movePool);
         * for (Move move : ima.getMoves()) {
         * move.printDetailMove();
         * }
         * System.out.println("STAT IMA SBLM");
         * ima.getCurrentStats().printDetailStats();
         * gw.getMoves().get(1).applyMove(gw, ima);
         * System.out.println("STAT IMA SESUDAH");
         * ima.getCurrentStats().printDetailStats();
         */
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
