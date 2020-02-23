package Map;

import Treasure.Treasure;
import Character.Player;
import java.util.ArrayList;

public class Room extends Location {
    private ArrayList<Player> enemies;

    public Room(String name, String description, int sizeInTiles, ArrayList<Treasure> treasures, ArrayList<Player> enemies) {
        super("room", name, description, sizeInTiles, treasures);
        this.enemies = enemies;
    }

    public ArrayList<Player> getEnemies() {
        return enemies;
    }

}
