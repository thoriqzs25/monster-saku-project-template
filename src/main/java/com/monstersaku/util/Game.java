// Masih ZONK :D

package com.monstersaku.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.monstersaku.Monsters.Monster;
import com.monstersaku.Player.*;

public class Game {

    private List<Player> playerList = new ArrayList<Player>();
    private int playerTurn;
    private String winner;

    public Game(List<Player> playerList, Scanner scan) {
        // Set list of players for the current game
        this.playerList = playerList;

        // Determine who goes first using shuffle collections
        Collections.shuffle(playerList);
        Player currentPlayer = playerList.get(0);

        // Let player choose what to do on his turn
        String cmd = new String();
        while (true) {
            // Display current player's name
            System.out.printf("--%s's TURN ---\n", currentPlayer.getName().toUpperCase());
            Display.showMenuDalamTurn();
            cmd = scan.next();
            Display.cls(); // Clear screen

            // Identifying user input
            switch (cmd) {
                case "1":
                    System.out.println("Move");
                    break;
                case "2":
                    System.out.println("Switch!");
                    break;
                case "3":
                    monsterInfo(currentPlayer);
                    break;
                case "4":
                    gameInfo();
                    break;
                case "5":
                    Game.help();
                    break;
                case "6":
                    Game.exit();
                    break;
                default:
                    System.out.println("");
                    break;
            }
        }
    }

    public void start() {

    }

    public static void help() {
        // Deskripsi Permainan
        System.out.println("Deskripsi Permainan: ");
        System.out.println("...");
        // Arahan bermain
        System.out.println("...");
    }

    public static void exit() {
        // Berhenti dari permainan
        System.out.println("Exit from the game.");
        System.exit(0);
    }

    public void monsterInfo(Player player) {
        // Menampilkan Atribut Monster yang ada dalam permainan
        /*
         * === LIST OF MONSTERS ====
         * id :
         * name :
         * .....
         * 
         */
        player.printMyMonster();
    }

    public void gameInfo() {
        // Menampilkan Info Permainan
        /*
         * ==== GAME INFO ====
         * In Turn : <Nama Player1>
         * Monster yang sedang Bertarung : Arrokuda
         * Monster yang sedang Tidak Bertarung : Charmander, Archanine
         * 
         * 
         */
        System.out.println(" ==== GAME INFO ==== ");
        System.out.println(" In Turn                             : ");
        System.out.println(" Monster yang sedang bertarung       : ");
        System.out.println(" Monster yang sedang tidak bertarung : ");
    }

    public void selectMove() {
        // Menampilkan moves yang dimiliki monster
        // Memilih moves
        // Eksekusi moves

    }

    public void switchMonster() {
        // Menampilkan list monsters pemain beserta health point
        // Memilih monster
        // Jika monster yang dipilih sudah mati (HealthPoint = 0) --> Pilih lagi
        // Jika tidak, set Monster yg bertarung
    }
}
