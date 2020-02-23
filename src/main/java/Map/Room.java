package Map;

import Treasure.Treasure;
import Character.Player;
import java.util.ArrayList;

public class Room extends Location {

    public Room(String name, String description, int sizeInTiles, ArrayList<Treasure> treasures, ArrayList<Player> enemies) {
        super("room", name, description, sizeInTiles, treasures, enemies);
    }

}
