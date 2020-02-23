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
    public Dwarf dwarf;
//    public Room room;
//    public Player enemy;
//    public ArrayList<Player> enemies;
//    public ArrayList<Player> party;
//    public ArrayList<Treasure> treasureList;
//    public Treasure gem;


    @Before
    public void before(){
//        enemy = new Dwarf("Brutus the Angry Dwarf");
//        enemies = new ArrayList<Player>();
//
//        treasureList = new ArrayList<Treasure>();
//        treasureList.add(gem);
//
//        room = new Room("Dungeon Entrance", "Empty disadorned room.", 10, treasureList, enemies);
        game = new Game(rules);
        dwarf = new Dwarf("Bob");
    }

    @Test
    public void starts_with_empty_party(){
        assertEquals(0, game.getParty().size());
    }

    @Test
    public void starts_with_1_location(){
        game.initialiseGame();
        assertEquals(1, game.getRooms().size());
    }

    @Test
    public void can_add_player(){
        game.addPlayerToParty(dwarf);
        assertEquals(true, game.getParty().contains(dwarf));
        assertEquals(1, game.getParty().size());
    }

    @Test
    public void can_remove_player(){
        game.addPlayerToParty(dwarf);
        game.removePlayerFromParty(dwarf);
        assertEquals(0, game.getParty().size());
    }

    @Test
    public void party_cannot_enter_first_room_if_no_players(){
        game.initialiseGame();
        ArrayList<Treasure> treasure = null;
        ArrayList<Player> enemy = null;
        Room room1 = new Room ("room", "test", 1, treasure, enemy);
        game.getRooms().add(0, room1);
        assertEquals(null, game.findNextLocation());
    }

    @Test
    public void party_can_enter_first_room(){
        game.initialiseGame();
        game.addPlayerToParty(dwarf);
        game.enterRoom(game.findNextLocation());
        assertEquals(1, game.getRooms().get(0).getParty().size());
    }

    @Test
    public void party_can_exit_first_room(){
        game.initialiseGame();
        game.addPlayerToParty(dwarf);
        game.enterRoom(game.findNextLocation());
        game.leaveRoom(game.getRooms().get(0));
        assertEquals(0, game.getRooms().get(0).getParty().size());
    }

}

