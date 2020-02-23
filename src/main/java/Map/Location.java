package Map;

import Treasure.IHaveTreasure;
import Treasure.Treasure;
import Character.Player;

import java.util.ArrayList;

public abstract class Location implements IHaveTreasure {
    private String type;
    private String name;
    private String description;
    private int sizeInTiles;
    private ArrayList<Treasure> treasureList;
    private ArrayList<Player> enemies;

    public Location(String type, String name, String description, int sizeInTiles,ArrayList<Treasure> treasures, ArrayList<Player> enemies ) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.sizeInTiles = sizeInTiles;
        this.treasureList = treasures;
        this.enemies = enemies;

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

    public ArrayList<Player> getEnemies() {
        return enemies;
    }


}
