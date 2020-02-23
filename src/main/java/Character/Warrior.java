package Character;

import Arm.Weapon;

import java.util.ArrayList;

public class Warrior extends Player {
    private ArrayList<Weapon> weapons;

    public Warrior(String name) {
        super(name);
        this.weapons = new ArrayList<Weapon>();
    }

    public ArrayList<Weapon> getWeaponList() {
        return this.weapons;
    }

    public void addWeapon(Weapon weapon) {
        this.weapons.add(weapon);
    }

}
