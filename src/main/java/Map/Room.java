package Map;

import Treasure.ITreasurable;

import java.util.ArrayList;

public class Room extends Location {

    public Room( String name, String description, int sizeInTiles, ArrayList<ITreasurable> treasures) {
        super("room", name, description, sizeInTiles, treasures);
    }

}
