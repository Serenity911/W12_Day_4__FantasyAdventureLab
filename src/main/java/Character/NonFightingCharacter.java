package Character;

import Healing.HealingTool;
import Treasure.ITreasurable;

import java.util.ArrayList;



public abstract class NonFightingCharacter implements IHeal, IHaveHealth, IHaveTreasure {
    private String name;
    private ArrayList<HealingTool> healingTools;
    private double defenceMultiplier;
    private double health;
    private ArrayList<ITreasurable> treasureList;

    public NonFightingCharacter(String name) {
        this.name = name;
        this.healingTools = new ArrayList<HealingTool>();
        this.defenceMultiplier = 1;
        this.health = 100;
        this.treasureList = new ArrayList<ITreasurable>();
    }

    public String getName() {
        return name;
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


    public ArrayList<ITreasurable> getTreasureList() {
        return this.treasureList;
    }

    public double getTreasureValue() {
        double total = 0;
        for (ITreasurable treasureItem: this.treasureList){
            total += treasureItem.getValue();
        }
        return total;
    }

    public void addTreasure(ITreasurable treasureItem) {
        this.treasureList.add(treasureItem);
    }

    public ArrayList<ITreasurable> dropTreasure() {
        ArrayList<ITreasurable> droppedTreasure = null;
        for (ITreasurable treasureItem : this.treasureList) {
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
