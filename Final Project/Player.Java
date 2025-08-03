public class Player extends Character {

    public Player(String name) {
        super(name, 100, 20, 5, 10, "Power Slash", 40);
    }

    @Override
    public String attack(Character target) {
        turnsTaken++;
        specialUsedLastTurn = false;
        target.takeDamage(attackPower);
        return name + " attacks for " + attackPower + " damage!";
    }

    @Override
    public String specialMove(Character target) {
        if (specialUsedLastTurn) {
            return name + " can't use Special twice in a row!";
    }

    turnsTaken++;
    specialUsedLastTurn = true;

    int preHP = target.health; // track HP before attack
    target.takeDamage(specialMovePower);

    int damageDealt = preHP - target.health;
    int healAmount = damageDealt / 2;
    boolean killed = !target.isAlive();

        if (killed) {
        healAmount += 20; // bonus on kill
    }

        this.heal(healAmount);

        return name + " uses " + specialMoveName + " for " + damageDealt + " damage"
           + (killed ? ", defeats the enemy," : "")
           + " and heals for " + healAmount + "!";
        }
    }
}