import Map.Room;
import Character.Player;
import Character.Dwarf;
import Character.Cleric;
import Character.Wizard;
import Treasure.Gem;
import Treasure.Treasure;
import com.sun.tools.jdi.EventSetImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RoomTest {
    public Room room;
    public ArrayList<Treasure> treasureList;
    public Treasure gem;
    public Treasure gem1;
    public Treasure gem2;
    public Treasure gem3;
    public Player enemy;
    public ArrayList<Player> enemies;
    public ArrayList<Player> party;
    public Wizard wizard;
    public Dwarf dwarf;
    public Cleric cleric;



    @Before
    public void before(){
        wizard = new Wizard("Jimmy");
        dwarf = new Dwarf("Jeff");
        cleric = new Cleric("Bob");
        party = new ArrayList<Player>();
        party.add(cleric);
        party.add(wizard);
        party.add(dwarf);


        gem = new Gem("Ruby", 10);
        gem1 = new Gem("Diamond", 50);
        gem2 = new Gem("Sapphire", 20);
        gem3 = new Gem("Small ruby", 7);

        treasureList = new ArrayList<Treasure>();
        treasureList.add(gem);
        treasureList.add(gem1);
        treasureList.add(gem2);

        enemy = new Dwarf("Brutus the Angry Dwarf");
        enemies = new ArrayList<Player>();
        enemies.add(enemy);

        room = new Room("Dungeon Entrance", "Empty disadorned room.", 10, treasureList, enemies);
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

    @Test
    public void can_get_enemies(){
        assertEquals(1, room.getEnemies().size());
    }

    @Test
    public void starts_with_no_party(){
        assertEquals(0, room.getParty().size());
    }

    @Test
    public void can_add_a_party(){
        room.addParty(party);
        assertEquals(true, room.getParty().contains(wizard));
        assertEquals(true, room.getParty().contains(dwarf));
        assertEquals(true, room.getParty().contains(cleric));
        assertEquals(3, room.getParty().size());
    }

    @Test
    public void can_remove_party(){
        room.addParty(party);
        room.removeParty();
        assertEquals(false, room.getParty().contains(wizard));
        assertEquals(false, room.getParty().contains(dwarf));
        assertEquals(false, room.getParty().contains(cleric));
        assertEquals(0, room.getParty().size());
    }

    @Test
    public void cannot_add_multiple_parties(){
        room.addParty(party);
        room.addParty(party);
        assertEquals(true, room.getParty().contains(wizard));
        assertEquals(true, room.getParty().contains(dwarf));
        assertEquals(true, room.getParty().contains(cleric));
        assertEquals(3, room.getParty().size());
    }

    @Test
    public void starts_as_not_solved(){
        assertEquals(false, room.getIsSolved());
    }

}
