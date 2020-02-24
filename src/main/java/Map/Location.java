package Map;

import Treasure.IHaveTreasure;
import Treasure.Treasure;
import Character.Player;
import Character.FightingPlayer;
import Character.Dwarf;
import Character.IFight;

import java.util.ArrayList;

public abstract class Location implements IHaveTreasure {
    private String type;
    private String name;
    private String description;
    private int sizeInTiles;
    private ArrayList<Treasure> treasureList;;
    protected ArrayList<Player> party;
    protected boolean isSolved;
    protected ArrayList<FightingPlayer> enemies;




    public Location(String type, String name, String description, int sizeInTiles,ArrayList<Treasure> treasures, ArrayList<FightingPlayer> enemies) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.sizeInTiles = sizeInTiles;
        this.treasureList = treasures;
        this.enemies = enemies;

        this.party = new ArrayList<Player>();
        this.isSolved = false;


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


    public ArrayList<Player> getParty(){
        return this.party;
    }

    public void addParty(ArrayList<Player> party) {
        if (this.party.size() == 0){
            this.party = party;
        }
    }

    public void removeParty(){
        if (this.party.size() > 0) {
            this.party.clear();
        }
    }

    public boolean getIsSolved() {
        return isSolved;
    }

    public ArrayList<FightingPlayer> getEnemies() {
        return enemies;
    }

    public FightingPlayer getEnemyLowestHealth(){
        FightingPlayer weakestEnemy = new Dwarf("test");
        for (FightingPlayer enemy : this.enemies){
           if( enemy.getHealth() <= weakestEnemy.getHealth()) {
               weakestEnemy = enemy;
           }
        }
        return weakestEnemy;
    }

    public FightingPlayer getPartyPlayerLowestHealth(){
        FightingPlayer weakestPartyPlayer = new Dwarf("test");
        for (FightingPlayer enemy : this.enemies){
            if( enemy.getHealth() <= weakestPartyPlayer.getHealth()) {
                weakestPartyPlayer = enemy;
            }
        }
        return weakestPartyPlayer;
    }

//    todo
//    why cannot be used for both, passing a fighting player? it should still be a player!
//    public Player getLowestHealth(ArrayList<Player> players){
//        Player weakestPlayer = new Dwarf("test");
//        for (Player player : players){
//            if(player.getHealth() <= weakestPlayer.getHealth()) {
//                weakestPlayer = player;
//            }
//        }
//        return weakestPlayer;
//    }

    public void setIsSolved(boolean solved) {
        this.isSolved = solved;
    }
}
