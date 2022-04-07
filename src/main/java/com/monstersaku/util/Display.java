package com.monstersaku.util;

import com.monstersaku.Monsters.Monster;
import com.monstersaku.Moves.Move;

public class Display {
    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void loading(int time) {
        for (int i = 0; i < 5; i++) {
            System.out.printf(".");
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                System.out.println("Loading display error");
            }
        }
        System.out.printf("\n");
    }

    public static void showMenuAwal() {
        System.out.println("GAME MENU");
        System.out.println("1. START");
        System.out.println("2. HELP");
        System.out.println("3. EXIT");
        System.out.printf("Input : ");
    }

    public static void showMenuDalamTurn() {
        System.out.println("GAME MENU");
        System.out.println("1. MOVE");
        System.out.println("2. SWITCH");
        System.out.println("3. MONSTER INFO");
        System.out.println("4. GAME INFO");
        System.out.println("5. HELP");
        System.out.println("6. EXIT");
        System.out.printf("Input : ");
    }

    public static void showAvailableMove(Monster monster) {
        System.out.println("----- Moves of " + monster.getName() + " -----");
        for (Move move : monster.getMoves()) {
            System.out.println("id move: " + move.getId());
            System.out.println("move name: " + move.getName());
            System.out.println(" ");
        }
    }
}
