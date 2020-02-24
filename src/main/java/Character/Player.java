package Character;

import Treasure.IHaveTreasure;
import Treasure.Treasure;

import java.util.ArrayList;

public abstract class Player implements IHaveHealth, IHaveTreasure {
    private String name;
    protected double attackMultiplier;
    protected double defenceMultiplier;
    protected double health;
    protected ArrayList<Treasure> treasureList;
    protected boolean isAlive;

    public Player(String name) {
        this.name = name;
        this.attackMultiplier = 6;
        this.defenceMultiplier = 8;
        this.health = 100;
        this.treasureList = new ArrayList<Treasure>();
        this.isAlive = true;
    }
    public String getName() {
        return name;
    }

    public double getAttackMultiplier() {
        return attackMultiplier;
    }

    public double getDefenceMultiplier() {
        return defenceMultiplier;
    }

    public double getHealth() {
        return health;
    }



    public void reduceHealth(double amount) {
        if (this.health > 0) {
            this.health -= amount;
        }
        if (this.health <= 0) {
            this.isAlive = false;
        }
    }

    public void increaseHealth(double amount) {
        this.health += amount;

    }

    public ArrayList<Treasure> getTreasureList() {
        return this.treasureList;
    }

    public double getTreasureValue() {
        double total = 0;
        for (Treasure treasureItem: this.treasureList){
            total += treasureItem.getValue();
        }
        return total;
    }

    public void addTreasure(Treasure treasureItem) {
        this.treasureList.add(treasureItem);
    }

    public ArrayList<Treasure> dropTreasure() {
        ArrayList<Treasure> droppedTreasure = new ArrayList<Treasure>();
        for (Treasure treasureItem : this.treasureList) {
            droppedTreasure.add(treasureItem);
        }
        this.treasureList.clear();
        return droppedTreasure;
    }

    public boolean getIsAlive(){
        return this.isAlive;
    }
}
