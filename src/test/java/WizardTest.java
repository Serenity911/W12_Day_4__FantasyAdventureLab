import Arm.Arm;
import Arm.Spell;
import org.junit.Before;
import org.junit.Test;
import Character.Wizard;

import static org.junit.Assert.assertEquals;

public class WizardTest {

    public Wizard wizard;
    public Spell spell;
    public Spell spell1;

    @Before
    public void before(){
        wizard = new Wizard("Jimmy");
        spell = new Spell("Fireball", 10);
        spell1 = new Spell("Lighter", 5);

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

    @Test
    public void get_most_powerful_spell(){
        wizard.addSpell(spell);
        wizard.addSpell(spell1);
        assertEquals(spell, wizard.getMostPowerfulArm());
    }

    @Test
    public void can_attack(){
        wizard.addSpell(spell);
        double result = wizard.attack();
        assertEquals(true, (result > 0.6 && result <=12));
    }

}
