package Character;

import Arm.Arm;
import Arm.Spell;

import java.util.ArrayList;

public class Spellcaster extends FightingPlayer {
    private ArrayList<Spell> spells;

    public Spellcaster(String name) {
        super(name);
        this.spells = new ArrayList<Spell>();
    }
    public ArrayList<Spell> getSpellList() {
        return this.spells;
    }

    public void addSpell(Spell spell) {
        this.spells.add( spell);
    }

    public Spell getSpellByName(String name){
        for (Spell spell : this.spells){
            if (spell.getName() == name){
                return spell;
            }
        }
        return null;
    }

    public Arm getMostPowerfulArm(){
//        TODO
//        ?? why if I put null it doesn't work?
        Spell mostPowerfulSpell = new Spell("test", 0);
        for (Spell spell : this.spells) {
            if (spell.getDamage() > mostPowerfulSpell.getDamage()) {
                mostPowerfulSpell = spell;
            }
        }
        return mostPowerfulSpell;
    }

    public double rollDiceD(int dNumber) {
        double r = (Math.random() * (dNumber - 1)) + 1;
        return r;
    }

    public double attack() {
        return (this.attackMultiplier/100) * this.getMostPowerfulArm().getDamage()* rollDiceD(20) ;
    }
}
