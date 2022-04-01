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
    public void countMonster(List<Monster> listOfMonster){
        for(Monster monster:listOfMonster){
            if (monster.getCurrentStats().getHealthPoint() != 0) {
                numOfMonster += 1;
            } else {
                numOfMonster += 0;
            }
           
        }
    }
    public int outputCount(){
        return this.numOfMonster;
    }
}
