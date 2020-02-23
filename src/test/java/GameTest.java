import Game.Game;
import Game.Rules;
import Character.Player;
import Character.Dwarf;
import Map.Room;
import Treasure.Treasure;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {
    public Game game;
    public Rules rules;
    public Room room;
    public Player enemy;
    public ArrayList<Player> enemies;
    public ArrayList<Player> party;
    public ArrayList<Treasure> treasureList;
    public Treasure gem;

    @Before
    public void before(){
        enemy = new Dwarf("Brutus the Angry Dwarf");
        enemies = new ArrayList<Player>();

        treasureList = new ArrayList<Treasure>();
        treasureList.add(gem);

        room = new Room("Dungeon Entrance", "Empty disadorned room.", 10, treasureList, enemies);
        game = new Game(rules, room);
    }

    @Test
    public void starts_with_empty_party(){
        assertEquals(0, game.getParty().size());
    }

    @Test
    public void starts_with_a_location(){
        assertEquals(room, game.getRoom());
    }

}

