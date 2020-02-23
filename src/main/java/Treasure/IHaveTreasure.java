package Treasure;

import Treasure.ITreasurable;

import java.util.ArrayList;

public interface IHaveTreasure {
    double getTreasureValue();
    void addTreasure(ITreasurable treasureItem);
    ArrayList<ITreasurable> dropTreasure();
}
