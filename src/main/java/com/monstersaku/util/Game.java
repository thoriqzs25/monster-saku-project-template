// Masih ZONK :D

package com.monstersaku.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.monstersaku.Monsters.Monster;
import com.monstersaku.Player.*;

public class Game {

    private List<Player> playerlist = new ArrayList<Player>();
    private int playerTurn;
    private String winner;

    public Game(){
        
    }

    public static void showMenuAwal(){
        System.out.println("GAME MENU");
        System.out.println("1. START");
        System.out.println("2. HELP");
        System.out.println("3. EXIT");
    }

    public static void showMenuDalamTurn(){
        System.out.println("GAME MENU");
        System.out.println("1. MOVE");
        System.out.println("2. SWITCH");
        System.out.println("3. View Monster Info");
        System.out.println("4. View Game Info");
        System.out.println("5. HELP");
        System.out.println("6. EXIT");
    }

    public void randomTurn(){
        Collections.shuffle(playerlist);
    }

    public void start(){ // Masih bingung ngeimplement mekanisme turn nyaa
        // Masing-masing player mendapatkan 6 monster secara acak
        int i;
        Scanner scan = new Scanner(System.in); // JANGAN LUPA DI CLOSE
        for (i=0;i<2;i++){ // Cuma ada 2 player sesuai spesifikasi
            //pembuatan objek player
            System.out.printf("Masukkan nama Player%d: ", i+1);
            String name = scan.next();
            Player player = new Player(name);

            //pembacaan monster pool
            List<Monster> monsterpool = new ArrayList<Monster>();
            monsterpool = CreateObjectMonsterPool.create();
            
            //randomize
            AddListMonster.AddMonsters(player, monsterpool);
            playerlist.add(player);

        }
        // Masing-masing player  mendapatkan urutan bermain
        randomTurn(); // Akan mendapatkan pemain giliran pertama
        Player player_now = playerlist.get(0); // Pemain giliran awal

        // Masing-masing player dipilihkan 1 monster secara acak di awal untuk bertarung
        List<Monster> listMonster_playernow = player_now.getListOfMonsters();
        Collections.shuffle(listMonster_playernow);
        Monster monster_now = listMonster_playernow.get(0);

        // Show Game Info

        // SETIAP TURN
        // Tampilkan Menu Dalam Turn --> Untuk melihat info dalam permainan
        Game.showMenuDalamTurn();
        System.out.println("Pilihan: " );
        String pilihanmain = scan.next();

        // Jika memilih menu selain 1 dan 2, eksekusi menu --> Tampilkan menu dalam turn lagi
        if (pilihanmain.equals("3")){
            this.MonsterInfo();
        }else if (pilihanmain.equals("4")){
            this.GameInfo();
        }else if (pilihanmain.equals("1")){
            selectMove();
        }
        // Jika memilih menu 1 atau 2, eksekusi menu --> Ganti giliran
        // Jika memilih menu selain yang ditampilkan --> Tampilkan menu dalam turn lagi

        
    }

    public void help(){
        // Deskripsi Permainan
        System.out.println("Deskripsi Permainan: ");
        System.out.println("...");
        // Arahan bermain
        System.out.println("...");
    }

    public void exit(){
        // Berhenti dari permainan
        System.out.println("Exit from the game.");
        System.exit(0);
    }

    public void MonsterInfo(){
        // Menampilkan Atribut Monster yang ada dalam permainan
        /*
            === LIST OF MONSTERS ====
            id :
            name :
            .....
        
        */

        for (int i=0; i<2; i++){
            playerlist.get(i).printMyMonster();
        }
    }

    public void GameInfo(){
        // Menampilkan Info Permainan
        /*
            ==== GAME INFO ====
        In Turn                             : <Nama Player1>
        Monster yang sedang Bertarung       : Arrokuda
        Monster yang sedang Tidak Bertarung : Charmander, Archanine

        
        */
        System.out.println(" ==== GAME INFO ==== ");
        System.out.println(" In Turn                             : " );
        System.out.println(" Monster yang sedang bertarung       : ");
        System.out.println(" Monster yang sedang tidak bertarung : ");
    }

    public void selectMove(){
        // Menampilkan moves yang dimiliki monster
        // Memilih moves
        // Eksekusi moves
        
    }

    public void switchMonster(){
        // Menampilkan list monsters pemain beserta health point 
        // Memilih monster
        // Jika monster yang dipilih sudah mati (HealthPoint = 0) --> Pilih lagi
        // Jika tidak, set Monster yg bertarung
    }
}

