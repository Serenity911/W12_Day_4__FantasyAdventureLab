package Map;

import Treasure.Treasure;
import Character.FightingPlayer;
import Character.IFight;
import java.util.ArrayList;

public class Room extends Location {
    private ArrayList<FightingPlayer> defeatedEnemies;



    public Room(String name, String description, int sizeInTiles, ArrayList<Treasure> treasures, ArrayList<FightingPlayer> enemies) {
        super("room", name, description, sizeInTiles, treasures, enemies);
        this.defeatedEnemies = new ArrayList<FightingPlayer>();
    }


    public void defeatEnemy(FightingPlayer enemy) {
        if(this.enemies.contains(enemy)) {
            this.defeatedEnemies.add(enemy);
            this.enemies.remove(enemy);
            if(this.enemies.size() == 0) {
                this.isSolved = true;
            }
        }
    }

    public ArrayList<FightingPlayer> getDefeatedEnemies() {
        return defeatedEnemies;
    }



}
