package Game;
import Character.Player;
import Character.Dwarf;
import Map.FinalRoom;
import Map.Location;
import Map.Room;
import Treasure.Treasure;
import Treasure.Gem;

import java.util.ArrayList;

public class Game {
//    rules should be interface
    private Rules rules;
    private ArrayList<Player> party;
    private ArrayList<Location> rooms;
    private Location room1;
    private Location winnersRoom;
    private ArrayList<Treasure> winnersTreasure;

//    all these things can they be added in a separate file and used to initialise the Game?
    private ArrayList<Treasure> treasureList;
    private ArrayList<Player> enemies;
    private Gem gem;
    private Player enemy;

    public Game(Rules rules) {
        this.rules = rules;
        this.party = new ArrayList<Player>();
        this.rooms = new ArrayList<Location>();


    }

    public void initialiseGame(){
        this.gem = new Gem("Ruby", 10);
        this.treasureList = new ArrayList<Treasure>();
        this.treasureList.add(gem);
        this.enemy = new Dwarf("Brutus the Angry Dwarf");
        this.enemies = new ArrayList<Player>();
        this.enemies.add(enemy);
        this.room1 = new Room("Dungeon Entrance", "Empty disadorned room.", 10, treasureList, enemies);
        this.rooms.add(room1);

        this.winnersTreasure = new ArrayList<Treasure>();
        this.winnersTreasure.add(gem);
        this.winnersTreasure.add(gem);
        this.winnersTreasure.add(gem);
        this.winnersTreasure.add(gem);
        this.winnersTreasure.add(gem);
        this.winnersTreasure.add(gem);
        this.winnersRoom = new FinalRoom("Celebration Room", "The Great Hall of winners",  "You won! Enjoy the treasure and get ready for a new adventure", 20, winnersTreasure);
    }

    public ArrayList<Player> getParty() {
        ArrayList<Player> partyToReturn = this.party;
        return partyToReturn;
    }


    public ArrayList<Location> getRooms() {
        return this.rooms;
    }

    public void addPlayerToParty(Player player){
        this.party.add(player);
    }

    public void removePlayerFromParty(Player player) {
        this.party.remove(player);
    }

    public Location findNextLocation(){
        if (this.party.size() > 0 ) {
            for (Location location : this.rooms){
                if (location.getIsSolved() == false) {
                    return location;
                }
            }
            return this.winnersRoom;
        }
        return null;
    }

    public void enterRoom(Location location){
            location.addParty(party);
    }

    public void leaveRoom(Location location) {
        location.removeParty();
    }


}