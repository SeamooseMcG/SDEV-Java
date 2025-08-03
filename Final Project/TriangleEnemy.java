import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class TriangleEnemy extends Enemy {

    public TriangleEnemy() {
        super("Triangle", 60, 30, 2, 12, "Piercing Stab", 45);
    }

    @Override
    public String attack(Character target) {
        turnsTaken++;
        specialUsedLastTurn = false;
        target.takeDamage(attackPower);
        return name + " slashes for " + attackPower + " damage!";
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
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(0.0, 0.0, 40.0, 0.0, 20.0, 40.0);
        triangle.setFill(Color.CRIMSON);
        return triangle;
    }
}