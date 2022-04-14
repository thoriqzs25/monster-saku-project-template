// Masih ZONK :D

package com.monstersaku.util;

import java.lang.Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.monstersaku.Monsters.Monster;
import com.monstersaku.Moves.Move;
import com.monstersaku.Moves.StatusMove;
import com.monstersaku.Player.*;
import com.monstersaku.Status.*;

public class Game {

    private List<Player> playerList = new ArrayList<Player>();
    private int playerTurn = 0; // Indicate first index player
    private String winner;
    private Player currentPlayer;
    private Boolean nextPlayer; // Trigger to indicate if a player turn has ended
    private int turn = 1;
    private int endEffectTurn = 0;
    private int turnDapatBerjalan = 0;

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
            turn++;

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
                System.out.println("--TURN: " + turn + " ---");
                currentMonsterStats(); // Nampilin status monster skrg
                if (applyStatusConditon(currentPlayer.getCurrentMonster())) {
                    currentPlayer.setCurrentMove(null);
                    System.out.println(currentPlayer.getCurrentMove() == null);
                    switchPlayer();
                    nextPlayer = true;
                    break;
                }
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
            accumulateAction(scan);
        } else if (playerList.get(0).getCurrentMove() != null) {
            System.out.println("#### ONYL FIRST PLAYER ####");
            onlyPlayer1(scan);
        } else if (playerList.get(1).getCurrentMove() != null) {
            System.out.println("#### ONYL SECOND PLAYER ####");
            onlyPlayer2(scan);
        }
    }

    public static void help() {
        // Deskripsi Permainan
        System.out.println("About the Game: ");
        System.out.println("Monster Saku merupakan sebuah permainan yang diadaptasi dari permainan Pokemon. ");
        System.out.println("Permainan ini merupakan jenis permainan PvP (Player vs Player) yang bisa dimainkan oleh ");
        System.out.println(
                "dua pemain yang saling berlawanan. Masing-masing pemain akan menerima kombinasi enam monster ");
        System.out.println("yang ditentukan secara acak oleh aplikasi pada setiap permainan.");

        // Arahan bermain
        System.out.println("How to Play: ");
        System.out.println("1. Masukkan nama pemain");
        System.out.println("2. Setiap pemain akan diberikan 6 monster di awal permainan.");
        System.out.println("3. Setiap pemain akan masuk ke fase pertarungan");
        System.out.println(
                "4. Setiap pemain secara bergiliran bisa mengganti monster nya (switch) ataupun memilih movenya.");
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
        int indexMonster = player.getIndexMonster();
        double monsterHP = 1;
        if (id >= 0 && id < player.getListOfMonsters().size()) {
            monsterHP = player.getListOfMonsters().get(id).getCurrentStats().getHealthPoint();
        }
        while (id > player.getListOfMonsters().size() - 1 || id < 0 || id == indexMonster || monsterHP <= 0) {
            if (id > player.getListOfMonsters().size() - 1 || id < 0) {
                System.out.println("Input not valid!!");
            } else if (monsterHP <= 0) {
                System.out.println("Monster had died, choose other monster!");
            } else if (id == indexMonster) {
                System.out.println("Anda sedang menggunakan monster tersebut");
            }
            System.out.printf("Input No. to switch: ");
            id = scan.nextInt() - 1;
            if (id >= 0 && id < player.getListOfMonsters().size()) {
                monsterHP = player.getListOfMonsters().get(id).getCurrentStats().getHealthPoint();
            }
        }
        player.setCurrentMonster(player.getListOfMonsters().get(id));
        player.setIndextMonster(id);

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

    public void currentMonsterStats() {
        Monster monster = currentPlayer.getCurrentMonster();
        System.out.println("Monster name: " + monster.getName());
        System.out.println("Status condition: " + monster.getStatusCondition());
        System.out.printf("Monster remaining HP: %.1f/%.1f\n", monster.getCurrentStats().getHealthPoint(),
                monster.getBaseStats().getInitialHealthPoint());
    }

    public boolean monsterHadDied(Monster monster) {
        if (monster.getCurrentStats().getHealthPoint() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean applyStatusConditon(Monster monster) {
        String status = monster.getStatusCondition();
        Stats currentStats = monster.getCurrentStats();
        Stats baseStats = monster.getBaseStats();
        if (status.equals("POISON")) {
            System.out.println(monster.getName() + " terkena damage poison");
            double damage = baseStats.getHealthPoint() / 16;
            double updateHP = currentStats.getHealthPoint() - damage;
            if (updateHP <= 0) {
                updateHP = 0;
            }
            currentStats.setHealthPoint(updateHP);
            monster.setCurrentStats(currentStats);
            return false;
        } else if (status.equals("SLEEP") && endEffectTurn > 0) {
            System.out.println("----Effect Sleep----");
            System.out.println(monster.getName() + " masih tertidur");
            endEffectTurn--;
            System.out.println("Dapat berjalan lagi pada turn: " + (turnDapatBerjalan + 1));
            System.out.println("--------------------");
            System.out.println("");
            return true;
        } else if (status.equals("SLEEP") && endEffectTurn <= 0) {
            monster.setStatusCondition("-");
            return false;
        } else if (status.equals("PARALYZE")) {
            if (StatusMove.randomTurnsParalzeEffect()) {
                System.out.println("----Effect Paralyze----");
                System.out.println("Monster tidak bisa bergerak");
                System.out.println("--------------------");
                System.out.println("");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean isPlayer1MoveFirst(int priority1, int priority2, double speed1, double speed2) {

        if (priority1 > priority2) {
            return true;
        } else if (priority1 < priority2) {
            return false;
        } else {
            if (speed1 > speed2) {
                return true;
            } else if (speed1 < speed2) {
                return false;
            } else {
                int range = 2;
                int rand = (int) (Math.random() * range) + 1;
                if (rand == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    // Start action for each round
    public void accumulateAction(Scanner scan) {
        // Assign each player
        Player player1 = playerList.get(0);
        Player player2 = playerList.get(1);
        // Assign each move that each player currently are using
        Move move1 = player1.getCurrentMove();
        Move move2 = player2.getCurrentMove();
        // Assign each player's currentMove's priority
        int priority1 = move1.getPriority();
        int priority2 = move2.getPriority();

        // Assign each player's speed
        double speed1 = player1.getCurrentMonster().getBaseStats().getSpeed();
        double speed2 = player2.getCurrentMonster().getBaseStats().getSpeed();
        // Assign sleep
        boolean sleep1 = false;
        boolean sleep2 = false;
        // Assign Paralyze
        boolean paralyze1 = false;
        boolean paralyze2 = false;
        // Boolean untuk mengecek siapa yang duluan
        boolean moveplayer1 = isPlayer1MoveFirst(priority1, priority2, speed1, speed2);
        boolean enemyMove = true;

        boolean monstersdied1 = false;
        boolean monstersdied2 = false;
        // Eksekusi Move
        if (moveplayer1) {
            move1.applyMove(player1.getCurrentMonster(), player2.getCurrentMonster());
            monstersdied2 = player2.isAllMonsterDied();

            // Cek apakah semua monster player 2 mati
            if (monstersdied2) {
                player1Win(player1);
            }

            // Setting endEffectTurn bila menggunakan SLEEP
            sleep1 = move1.getEffect().getStatusCondition().equals("SLEEP");
            if (sleep1) {
                endEffectTurn = StatusMove.randomTurnSleepEffect();
                turnDapatBerjalan = turn + endEffectTurn;
                enemyMove = false;
                System.out.println("----Effect Sleep----");
                System.out.println(
                        "Move dari " + player2.getName() + " tidak dijalankan karena monster terkena effect Sleep");
                System.out.println("--------------------");
                System.out.println("");
            }
            // Setting effect paraylze
            paralyze1 = move1.getEffect().getStatusCondition().equals("PARALYZE");
            if (paralyze1) {
                if (StatusMove.randomTurnsParalzeEffect()) {
                    enemyMove = false;
                    System.out.println("----Effect Paralyze----");
                    System.out.println(
                            "Move dari " + player2.getName()
                                    + " tidak dijalankan karena monster terkena effect Paralyze");
                    System.out.println("--------------------");
                }
            }
            // Cek enemy monster mati
            if (monsterHadDied(player2.getCurrentMonster())) {
                enemyMove = false;
                System.out.println(
                        player2.getName() + "'s Monster had died (" + player2.getCurrentMonster().getName() + ")");
                System.out.println("Switch your Monster");
                switchMonster(scan, player2);
            }
            if (enemyMove) {
                move2.applyMove(player2.getCurrentMonster(), player1.getCurrentMonster());
                monstersdied1 = player1.isAllMonsterDied();
                // Cek apakah monster player 1 mati semua
                if (monstersdied1) {
                    player2Win(player2);
                }
                // Setting endEffectTurn bila menggunakan SLEEP
                if (move2.getEffect().getStatusCondition().equals("SLEEP")) {
                    endEffectTurn = StatusMove.randomTurnSleepEffect();
                    turnDapatBerjalan = turn + endEffectTurn;
                }
                // Cek monster 1 mati
                if (monsterHadDied(player1.getCurrentMonster())) {
                    System.out.println(
                            player1.getName() + "'s Monster had died (" + player1.getCurrentMonster().getName() + ")");
                    System.out.println("Switch your Monster");
                    switchMonster(scan, player1);
                }
            }
        } else {
            move2.applyMove(player2.getCurrentMonster(), player1.getCurrentMonster());
            monstersdied1 = player1.isAllMonsterDied();
            // Cek apakah semua monster player 1 mati
            if (monstersdied1) {
                player2Win(player2);
            }
            // Setting endEffectTurn bila menggunakan SLEEP
            sleep2 = move2.getEffect().getStatusCondition().equals("SLEEP");
            if (sleep2) {
                enemyMove = false;
                endEffectTurn = StatusMove.randomTurnSleepEffect();
                turnDapatBerjalan = turn + endEffectTurn;
                System.out.println("----Effect Sleep----");
                System.out.println(
                        "Move dari " + player1.getName() + " tidak dijalankan karena monster terkena effect Sleep");
                System.out.println("--------------------");
                System.out.println("");
            }
            // Setting effect paraylze
            paralyze2 = move1.getEffect().getStatusCondition().equals("PARALYZE");
            if (paralyze2) {
                if (StatusMove.randomTurnsParalzeEffect()) {
                    enemyMove = false;
                    System.out.println("----Effect Paralyze----");
                    System.out.println(
                            "Move dari " + player2.getName()
                                    + " tidak dijalankan karena monster terkena effect Paralyze");
                    System.out.println("--------------------");
                }
            }
            // Cek monster 1 mati
            if (monsterHadDied(player1.getCurrentMonster())) {
                enemyMove = false;
                System.out.println(
                        player1.getName() + "'s Monster had died (" + player1.getCurrentMonster().getName() + ")");
                System.out.println("Switch your Monster");
                switchMonster(scan, player1);
            }
            if (enemyMove) {
                move1.applyMove(player1.getCurrentMonster(), player2.getCurrentMonster());
                monstersdied2 = player2.isAllMonsterDied();
                // Cek apakah semua monster player 2 mati
                if (monstersdied2) {
                    player1Win(player1);
                }
                // Setting endEffectTurn bila menggunakan SLEEP
                if (move1.getEffect().getStatusCondition().equals("SLEEP")) {
                    endEffectTurn = StatusMove.randomTurnSleepEffect();
                    turnDapatBerjalan = turn + endEffectTurn;
                }
                // Cek monster 2 mati
                if (monsterHadDied(player2.getCurrentMonster())) {
                    System.out.println(
                            player2.getName() + "'s Monster had died (" + player2.getCurrentMonster().getName() + ")");
                    System.out.println("Switch your Monster");
                    switchMonster(scan, player2);
                }
            }
        }
    }

    public void onlyPlayer1(Scanner scan) {
        Player player1 = playerList.get(0);
        Player player2 = playerList.get(1);
        Move move1 = player1.getCurrentMove();
        boolean monstersdied2 = false;
        move1.applyMove(player1.getCurrentMonster(), player2.getCurrentMonster());
        monstersdied2 = player2.isAllMonsterDied();
        // Cek apakah semua monster player 2 mati
        if (monstersdied2) {
            player1Win(player1);
        }
        // Setting endEffectTurn bila menggunakan SLEEP
        if (move1.getEffect().getStatusCondition().equals("SLEEP")) {
            endEffectTurn = StatusMove.randomTurnSleepEffect();
            turnDapatBerjalan = turn + endEffectTurn;
        }

        if (monsterHadDied(player2.getCurrentMonster())) {
            System.out.println(
                    player2.getName() + "'s Monster had died (" + player2.getCurrentMonster().getName() + ")");
            System.out.println("Switch your Monster");
            switchMonster(scan, player2);
        }
    }

    public void onlyPlayer2(Scanner scan) {
        Player player1 = playerList.get(0);
        Player player2 = playerList.get(1);
        Move move2 = player2.getCurrentMove();
        boolean monstersdied1 = false;
        move2.applyMove(player2.getCurrentMonster(), player1.getCurrentMonster());
        // Cek apakah semua monster player 1 mati
        if (monstersdied1) {
            player2Win(player2);
        }
        // Setting endEffectTurn bila menggunakan SLEEP
        if (move2.getEffect().getStatusCondition().equals("SLEEP")) {
            endEffectTurn = StatusMove.randomTurnSleepEffect();
            turnDapatBerjalan = turn + endEffectTurn;
        }

        // Cek monster 1 mati
        if (monsterHadDied(player1.getCurrentMonster())) {
            System.out.println(
                    player1.getName() + "'s Monster had died (" + player1.getCurrentMonster().getName() + ")");
            System.out.println("Switch your Monster");
            switchMonster(scan, player1);
        }
    }

    public void player1Win(Player player1) {
        System.out.println(player1.getName() + " is the Winner!!");
        try {
            Thread.sleep(5000);
            System.exit(0);
        } catch (Exception e) {
        }
    }

    public void player2Win(Player player2) {
        System.out.println(player2.getName() + " is the Winner!!");
        try {
            Thread.sleep(5000);
            System.exit(0);
        } catch (Exception e) {
        }
    }

}
