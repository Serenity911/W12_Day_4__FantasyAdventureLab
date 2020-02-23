package Map;

import Treasure.Treasure;
import Character.Player;
import java.util.ArrayList;

public class Room extends Location {
    private ArrayList<Player> defeatedEnemies;



    public Room(String name, String description, int sizeInTiles, ArrayList<Treasure> treasures, ArrayList<Player> enemies) {
        super("room", name, description, sizeInTiles, treasures, enemies);
        this.defeatedEnemies = new ArrayList<Player>();
    }


    public void defeatEnemy(Player enemy) {
        if(this.enemies.contains(enemy)) {
            this.defeatedEnemies.add(enemy);
            this.enemies.remove(enemy);
            if(this.enemies.size() == 0) {
                this.isSolved = true;
            }
        }
    }

    public ArrayList<Player> getDefeatedEnemies() {
        return defeatedEnemies;
    }



}
