package bridge.rpg;

// Abstraction: WHO is fighting. `weapon` is the bridge slot.
// Without the bridge you'd need KnightWithSword, KnightWithWand, WizardWithSword, WizardWithWand...
// (M x N classes). With it: 2 heroes + 2 weapons = 4 classes, and each new type adds just ONE.
public abstract class Hero {
    protected Weapon weapon;

    public Hero(Weapon weapon) {
        this.weapon = weapon;
    }
}
