package Character;

import Arm.Arm;
import Arm.Spell;

import java.util.ArrayList;

public class Spellcaster extends Player {
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

}
