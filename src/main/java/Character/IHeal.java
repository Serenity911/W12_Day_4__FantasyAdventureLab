package Character;

import Healing.HealingTool;

public interface IHeal {
    void heal(IHaveHealth target, HealingTool healingTool);
    }
