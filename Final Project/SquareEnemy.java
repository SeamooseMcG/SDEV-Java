import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SquareEnemy extends Enemy {

    public SquareEnemy() {
        super("Square", 120, 10, 5, 8, "Heavy Slam", 25);
    }

    @Override
    public String attack(Character target) {
        turnsTaken++;
        specialUsedLastTurn = false;
        target.takeDamage(attackPower);
        return name + " smashes for " + attackPower + " damage!";
    }

    @Override
    public String specialMove(Character target) {
        if (specialUsedLastTurn) return attack(target);
        turnsTaken++;
        specialUsedLastTurn = true;
        target.takeDamage(specialMovePower);
        return name + " uses " + specialMoveName + "!";
    }

    @Override
    public Node getVisual() {
        Rectangle square = new Rectangle(40, 40);
        square.setFill(Color.DARKBLUE);
        return square;
    }
}