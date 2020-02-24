package Character;

import Arm.Arm;
import Arm.Weapon;

import java.util.ArrayList;

public class Warrior extends FightingPlayer  {
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

    public Arm getMostPowerfulArm(){
        Weapon mostPowerfulWeapon = new Weapon("test", 0);
        for (Weapon weapon : this.weapons) {
            if (weapon.getDamage() > mostPowerfulWeapon.getDamage()) {
                mostPowerfulWeapon = weapon;
            }
        }
        return mostPowerfulWeapon;
    }

    public double rollDiceD(int dNumber) {
        double r = (Math.random() * (dNumber - 1)) + 1;
        return r;
    }

    public double attack() {
       return (this.attackMultiplier/100) * this.getMostPowerfulArm().getDamage()* rollDiceD(20) ;
    }
}
