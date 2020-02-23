import Arm.Arm;
import Arm.Spell;
import org.junit.Before;
import org.junit.Test;
import Character.Wizard;

import static org.junit.Assert.assertEquals;

public class WizardTest {

    public Wizard wizard;
    public Spell spell;

    @Before
    public void before(){
        wizard = new Wizard("Jimmy");
        spell = new Spell("Fireball", 10);
    }

    @Test
    public void spells_start_empty() {
        assertEquals(0, wizard.getSpellList().size());
    }

    @Test
    public void can_add_spell(){
        wizard.addSpell(spell);
        assertEquals(1, wizard.getSpellList().size());
        assertEquals(true, wizard.getSpellList().contains(spell));

    }



}
