package com.monstersaku.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import com.monstersaku.Monsters.Monster;
import com.monstersaku.Moves.Move;

public class Player {
    private String name;
    private Monster currentMonster;
    private List<Monster> listOfMonster = new ArrayList<Monster>();
    private int numOfMonster;
    private Move currentMove;

    public Player(String name) {
        this.name = name;
    }

    public void randomMonster() {
        Collections.shuffle(listOfMonster);
        this.currentMonster = listOfMonster.get(0);
    }

    public Monster getCurrentMonster() {
        return this.currentMonster;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addMonster(Monster monster) {
        listOfMonster.add(monster);
    }

    public int countMonster() {
        for (Monster monster : listOfMonster) {
            if (monster.getCurrentStats().getHealthPoint() != 0) {
                numOfMonster += 1;
            } else {
                numOfMonster += 0;
            }

        }
        return numOfMonster;
    }

    public int outputCount() {
        return this.numOfMonster;
    }

    public void setMonsterList(Monster monster) {
        listOfMonster.add(monster);
    }

    public void printMyMonster() {
        System.out.println();
        System.out.println("JUMLAH MONSTER " + this.getName().toUpperCase() + " : " + countMonster());
        System.out.println("Berikut adalah monster yang dimiliki oleh " + this.getName() + ": ");
        for (Monster monster : listOfMonster) {
            if (monster.isMonsterAlive()) {
                System.out.println(" ");
                monster.outputMonster();
                System.out.println("");
                System.out.println("----- Current Stats Monster " + monster.getName() + " -----");
                monster.getCurrentStats().printDetailStats();
                System.out.println("");
                System.out.println("----- Moves of " + monster.getName() + " -----");
                for (Move move : monster.getMoves()) {
                    System.out.println("id move: " + move.getId());
                    System.out.println("move name: " + move.getName());
                    System.out.println(" ");
                }
                System.out.println(" ");
            }
        }
    }

    public void setMonsters(List<Monster> monsters) {
        this.listOfMonster = monsters;

        // Assign random monster to use for the first turn
        randomMonster();
    }

    public List<Monster> getListOfMonsters() {
        return this.listOfMonster;
    }

    public Move getCurrentMove() {
        return currentMove;
    }

    public void setCurrentMove(Move move) {
        this.currentMove = move;
    }

    public void setCurrentMonster(Monster monster) {
        this.currentMonster = monster;
    }

    public boolean isAllMonsterDied() {
        int i = 0;
        while (true || i < 6) {
            // If a single monster still have HP, the loop will break and it will return
            // false;
            if (listOfMonster.get(i).getCurrentStats().getHealthPoint() > 0) {
                break;
                // If the last monster's HP is below 0, return true that all monster have 0 HP
            } else if (listOfMonster.get(5).getCurrentStats().getHealthPoint() <= 0) {
                return true;
            }
        }
        return false;
    }

}