package Game;
import Character.Player;
import Map.Location;

import java.util.ArrayList;

public class Game {
//    rules should be interface
    private Rules rules;
    private ArrayList<Player> party;
//    location should be Map, an array of locations
    private Location room;

    public Game(Rules rules, Location room) {
        this.rules = rules;
        this.party = new ArrayList<Player>();
        this.room = room;
    }

    public ArrayList<Player> getParty() {
        ArrayList<Player> partyToReturn = this.party;
        return partyToReturn;
    }

    public Location getRoom() {
        return room;
    }

    public void addPlayerToParty(Player player){
        this.party.add(player);
    }
}
