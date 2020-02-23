package Map;

import Treasure.IHaveTreasure;
import Treasure.ITreasurable;

import java.util.ArrayList;

public abstract class Location implements IHaveTreasure {
    private String type;
    private String name;
    private String description;
    private int sizeInTiles;
    private ArrayList<ITreasurable> treasureList;

    public Location(String type, String name, String description, int sizeInTiles,ArrayList<ITreasurable> treasures ) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.sizeInTiles = sizeInTiles;
        this.treasureList = treasures;

    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getSizeInTiles() {
        return sizeInTiles;
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
        ArrayList<ITreasurable> droppedTreasure = new ArrayList<ITreasurable>();
        for (ITreasurable treasureItem : this.treasureList) {
            droppedTreasure.add(treasureItem);
        }
        this.treasureList.clear();
        return droppedTreasure;
    }

}
