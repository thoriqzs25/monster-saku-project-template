package com.monstersaku.util;

import com.monstersaku.Main;
import com.monstersaku.util.ElementType;

import com.monstersaku.util.CSVReader;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class FindEffectivity {
    private static String fileName = "configs/element-type-effectivity-chart.csv";

    public static double getValue(ElementType self, ElementType enemy) {
        double value = 1;
        try {
            System.out.printf("Filename: %s\n", fileName);
            CSVReader reader = new CSVReader(new File(Main.class.getResource(fileName).toURI()), ";");
            reader.setSkipHeader(true);
            List<String[]> lines = reader.read();
            for (String[] line : lines) {
                ElementType selfType = ElementType.valueOf(line[0]);
                ElementType enemyType = ElementType.valueOf(line[1]);
                if (self == selfType && enemy == enemyType) {
                    value = Double.valueOf(line[2]);
                    break;
                }
            }

        } catch (Exception e) {
            // do nothing
            System.out.println("Error getValue effectivity");
        }
        return value;
    }
}
