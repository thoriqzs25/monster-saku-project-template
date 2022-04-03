package com.monstersaku.util;

import com.monstersaku.Monsters.Monster;
import com.monstersaku.Status.*;
import com.monstersaku.Moves.*;
import java.util.List;

import javax.lang.model.element.Element;

import java.util.ArrayList;

import com.monstersaku.util.CSVReader;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import com.monstersaku.Main;
import com.monstersaku.util.ElementType;

public class CreateObjectMonsterPool {
    private static String fileName = "configs/monsterpool.csv";

    public static List<Monster> create() {
        List<Monster> monsterlist = new ArrayList<Monster>();
        Integer[] random = new Integer[] { 1, 2, 3, 4, 5, 6 }; // misal
        List<Integer> intList = new ArrayList<>(Arrays.asList(random));
        try {
            System.out.printf("Filename: %s\n", fileName);
            CSVReader reader = new CSVReader(new File(Main.class.getResource(fileName).toURI()), ";");
            reader.setSkipHeader(true);
            List<String[]> lines = reader.read();
            for (String[] line : lines) {
                if (intList.contains(Integer.valueOf(line[0]))) {
                    // ID
                    int id = Integer.valueOf(line[0]);
                    // NAMA
                    String name = line[1];
                    // ELEMENTTYPE
                    String[] elements = (line[2]).split(",");
                    List<ElementType> eltype = new ArrayList<ElementType>();
                    for (String el : elements) {
                        ElementType elt = ElementType.valueOf(el);
                        eltype.add(elt);
                    }
                    // BASESTATS
                    String[] bs = (line[3]).split(",");
                    int[] baseStats = { 0, 0, 0, 0, 0, 0 };
                    for (int i = 0; i < 6; i++) {
                        baseStats[i] = Integer.valueOf(bs[i]);
                    }
                    Stats fixBaseStats = new Stats(baseStats[0], baseStats[1], baseStats[2], baseStats[3], baseStats[4],
                            baseStats[5]);
                    Monster monsread = new Monster(id, name, eltype, fixBaseStats, fixBaseStats);
                    // MOVE
                    String[] movstr = ((line[4]).split(","));
                    // mau ubah string array to int array
                    // hitung panjang movstr dulu
                    int count = 0;
                    for (String move : movstr) {
                        count += 1;
                    }
                    // ubah satu2
                    int[] moves = new int[count];
                    int idx;
                    for (idx = 0; idx < count; idx++) {
                        moves[idx] = Integer.valueOf(movstr[idx]);
                    }
                    // SET UP MOVE MILIK MONSTER
                    List<Move> movePool = new ArrayList<Move>();
                    movePool = CreateObjectMovePool.create();
                    AddListMove.add(monsread, moves, movePool);
                    monsterlist.add(monsread);

                }
            }
        } catch (Exception e) {
            // do nothing
            System.out.println("Unable to make monster list");
        }
        return monsterlist;
    }
}