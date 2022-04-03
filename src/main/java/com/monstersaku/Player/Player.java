package com.monstersaku.Player;
import java.util.ArrayList;
import java.util.List;
import com.monstersaku.Monsters.Monster;

public class Player{
    private String name;
    private List<Monster> listOfMonster = new ArrayList<Monster>();
    private int numOfMonster;
    public Player(String name, List<Monster> listOfMonster){
        this.name = name;
        this.listOfMonster = listOfMonster;

    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void addMonster(Monster monster){
        listOfMonster.add(monster);
    }
    public int countMonster(){
        for(Monster monster:listOfMonster){
            if (monster.getCurrentStats().getHealthPoint() != 0) {
                numOfMonster += 1;
            } else {
                numOfMonster += 0;
            }
           
        }
        return numOfMonster;
    }
    public int outputCount(){
        return this.numOfMonster;
    }
    public void setMonsterList(Monster monster){
        listOfMonster.add(monster);
    }
    public void printMyMonster(){
        System.out.println("Jumlah monster: " + countMonster());
        System.out.println("Berikut adalah monster yang kamu miliki: ");
        for (Monster monster:listOfMonster){
            if (monster.isMonsterAlive() == true){
                monster.outputMonster();
                System.out.println("----- Current Stats Monster " + monster.getName() + " -----");
                monster.getCurrentStats().printDetailStats();
                System.out.println("");
            }
        }
    }
}
