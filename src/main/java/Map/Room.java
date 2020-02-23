package Map;

import Treasure.Treasure;

import java.util.ArrayList;

public class Room extends Location {

    public Room( String name, String description, int sizeInTiles, ArrayList<Treasure> treasures) {
        super("room", name, description, sizeInTiles, treasures);
    }

}
