package Character;

import Healing.HealingTool;
import Treasure.Treasure;

import java.util.ArrayList;

public class Cleric extends Player implements IHeal {
    private ArrayList<HealingTool> healingTools;

    public Cleric (String name) {
        super(name);
        this.healingTools = new ArrayList<HealingTool>();
        this.defenceMultiplier = 1;
        this.health = 100;
        this.treasureList = new ArrayList<Treasure>();
    }


    public ArrayList<HealingTool> getHealingTools() {
        return healingTools;
    }

    public double getDefenceMultiplier() {
        return defenceMultiplier;
    }

    public double getHealth() {
        return health;
    }

    public void reduceHealth(double amount) {
        this.health -= amount;
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
        ArrayList<Treasure> droppedTreasure = null;
        for (Treasure treasureItem : this.treasureList) {
            droppedTreasure.add(treasureItem);
            this.treasureList.remove(treasureItem);
        }
        return droppedTreasure;
    }

    public void heal(IHaveHealth target, HealingTool healingTool) {
        if (this.healingTools.contains(healingTool)){
            target.increaseHealth(healingTool.getHealingAmount());
            this.healingTools.remove(healingTool);
        }
    }

    public void addHealingTool(HealingTool healingTool) {
        this.healingTools.add(healingTool);
    }
}
