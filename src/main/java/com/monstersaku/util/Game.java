// Masih ZONK :D

package com.monstersaku.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.monstersaku.Monsters.Monster;
import com.monstersaku.Moves.Move;
import com.monstersaku.Player.*;

public class Game {

    private List<Player> playerList = new ArrayList<Player>();
    private int playerTurn = 0; // Indicate first index player
    private String winner;
    private Player currentPlayer;
    private Boolean nextPlayer; // Trigger to indicate if a player turn has ended

    public Game(List<Player> playerList, Scanner scan) {
        // Set list of players for the current game
        this.playerList = playerList;

        // Determine who goes first using shuffle collections
        Collections.shuffle(playerList);
        currentPlayer = playerList.get(0);

        while (true) {
            // Start new round
            startRound(scan);
            System.out.println("BOTH PLAYER HAVE PICKED TURN");

            // Apply picked action

        }
    }

    public void startRound(Scanner scan) {
        // Let player choose what to do on his turn
        String cmd = new String();

        // Both player have turn to play
        for (int i = 0; i < 2; i++) {
            nextPlayer = false;
            while (!nextPlayer) {
                // Display current player's name
                System.out.printf("--%s's TURN ---\n", currentPlayer.getName().toUpperCase());
                Display.showMenuDalamTurn();
                cmd = scan.next();
                Display.cls(); // Clear screen

                // Identifying user input
                switch (cmd) {
                    case "1":
                        Display.showAvailableMove(currentPlayer.getCurrentMonster());
                        currentPlayer.getCurrentMonster().play(scan, currentPlayer);
                        switchPlayer();
                        nextPlayer = true;
                        break;
                    case "2":
                        System.out.println("Switch!!");
                        switchMonster(scan, currentPlayer);
                        currentPlayer.setCurrentMove(null);
                        switchPlayer();
                        nextPlayer = true;
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

        // If both player choose to move their monster
        if (playerList.get(0).getCurrentMove() != null && playerList.get(1).getCurrentMove() != null) {
            accumulateAction();
        }
    }

    public static void help() {
        // Deskripsi Permainan
        System.out.println("About the Game: ");
        System.out.println("Monster Saku merupakan sebuah permainan yang diadaptasi dari permainan Pokemon. ");
        System.out.println("Permainan ini merupakan jenis permainan PvP (Player vs Player) yang bisa dimainkan oleh ");
        System.out.println("dua pemain yang saling berlawanan. Masing-masing pemain akan menerima kombinasi enam monster ");
        System.out.println("yang ditentukan secara acak oleh aplikasi pada setiap permainan.");

        // Arahan bermain
        System.out.println("How to Play: ");
        System.out.println("1. Masukkan nama pemain");
        System.out.println("2. Setiap pemain akan diberikan 6 monster di awal permainan.");
        System.out.println("3. Setiap pemain akan masuk ke fase pertarungan");
        System.out.println("4. Setiap pemain secara bergiliran bisa mengganti monster nya (switch) ataupun memilih movenya.");
        System.out.println("5. Move akan dieksekusi secara bergiliran berdasarkan prioritas dan speed");
        System.out.println("6. Pemain dengan monster setidaknya satu di akhir permainan akan menjadi pemenang.");
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

    public void switchMonster(Scanner scan, Player player) {
        // Show available monster on player's monster list
        Display.showAvailableMonster(player.getListOfMonsters());
        System.out.printf("Input No. to switch: ");
        int id = scan.nextInt() - 1;

        // If input id is out of range
        if (id < player.getListOfMonsters().size() && id >= 0) {
            player.setCurrentMonster(player.getListOfMonsters().get(id));
        } else {
            while (id > player.getListOfMonsters().size() && id < 0) {
                id = scan.nextInt();
                player.setCurrentMonster(player.getListOfMonsters().get(id));
            }
        }

        // Validate if monster HP below 0
        while (player.getCurrentMonster().getBaseStats().getHealthPoint() <= 0) {
            id = scan.nextInt();
            player.setCurrentMonster(player.getListOfMonsters().get(id));
        }

        // Display the monster that has been switched successfully
        System.out.printf("Succeed to switch to %s\n\n", player.getCurrentMonster().getName());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Failed to switch monster!!!");
        }

        // Menampilkan list monsters pemain beserta health point
        // Memilih monster
        // Jika monster yang dipilih sudah mati (HealthPoint = 0) --> Pilih lagi
        // Jika tidak, set Monster yg bertarung
    }

    public void switchPlayer() {
        // Switch player to player 1 if player turn mod by 2 is 0, vice versa
        playerTurn++;
        currentPlayer = playerList.get(playerTurn % 2);
    }

    // Start action for each round
    public void accumulateAction() {
        // Assign each player
        Player player1 = playerList.get(0);
        Player player2 = playerList.get(1);
        // Assign each move that each player currently are using
        Move move1 = player1.getCurrentMove();
        Move move2 = player2.getCurrentMove();
        // Assign each player's currentMove's priority
        int priority1 = move1.getPriority();
        int priority2 = move2.getPriority();

        // Check which priority to move first
        if (priority1 > priority2) {
            move1.applyMove(player1.getCurrentMonster(), player2.getCurrentMonster());
            move2.applyMove(player2.getCurrentMonster(), player1.getCurrentMonster());
        } else if (priority1 == priority2) {
            // Asumsi belom random CAUTION!!!
            move1.applyMove(player1.getCurrentMonster(), player2.getCurrentMonster());
            move2.applyMove(player2.getCurrentMonster(), player1.getCurrentMonster());
        } else {
            move2.applyMove(player2.getCurrentMonster(), player1.getCurrentMonster());
            move1.applyMove(player1.getCurrentMonster(), player2.getCurrentMonster());
        }
    }

}
