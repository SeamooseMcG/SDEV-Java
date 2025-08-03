public abstract class Enemy extends Character {

    public Enemy(String name, int maxHealth, int attackPower, int defense, int speed,
                 String specialMoveName, int specialMovePower) {
        super(name, maxHealth, attackPower, defense, speed, specialMoveName, specialMovePower);
    }

    // All enemies must define a shape for display
    public abstract javafx.scene.Node getVisual();

    // Default enemy turn behavior
    public String takeTurn(Character target) {
        if (!specialUsedLastTurn && Math.random() < 0.5) {
            return specialMove(target);
        } else {
            return attack(target);
        }
    }
}