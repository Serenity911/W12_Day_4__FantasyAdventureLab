package Treasure;


import java.util.ArrayList;

public interface IHaveTreasure {
    double getTreasureValue();
    void addTreasure(Treasure treasureItem);
    ArrayList<Treasure> dropTreasure();
}
