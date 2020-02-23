import Map.Room;
import Treasure.Gem;
import Treasure.ITreasurable;
import com.sun.tools.jdi.EventSetImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RoomTest {
    public Room room;
    public ArrayList<ITreasurable> treasureList;
    public ITreasurable gem;
    public ITreasurable gem1;
    public ITreasurable gem2;
    public ITreasurable gem3;


    @Before
    public void before(){
        gem = new Gem("Ruby", 10);
        gem1 = new Gem("Diamond", 50);
        gem2 = new Gem("Sapphire", 20);
        gem3 = new Gem("Small ruby", 7);

        treasureList = new ArrayList<ITreasurable>();
        treasureList.add(gem);
        treasureList.add(gem1);
        treasureList.add(gem2);

        room = new Room("Dungeon Entrance", "Empty disadorned room.", 10, treasureList);
    }

    @Test
    public void can_get_type(){
        assertEquals("room", room.getType());
    }

    @Test
    public void can_get_name(){
        assertEquals("Dungeon Entrance", room.getName());
    }

    @Test
    public void can_get_description(){
        assertEquals("Empty disadorned room.", room.getDescription());
    }

    @Test
    public void can_get_size_in_tiles(){
        assertEquals(10, room.getSizeInTiles());
    }

    @Test
    public void can_get_treasure_list_size_starts_at_3(){
        assertEquals(3, room.getTreasureList().size());
    }

    @Test
    public void can_add_treasure(){
       room.getTreasureList().add(gem3);
        assertEquals(4, room.getTreasureList().size());
        assertEquals(true, room.getTreasureList().contains(gem3));
    }

    @Test
    public void can_drop_treasure(){
        assertEquals(3, room.dropTreasure().size());
        assertEquals(0, room.getTreasureList().size());

    }

}
