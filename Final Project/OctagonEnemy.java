import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class OctagonEnemy extends Enemy {

    public OctagonEnemy() {
        super("Octagon", 90, 20, 4, 10, "Spin Strike", 35);
    }

    @Override
    public String attack(Character target) {
        turnsTaken++;
        specialUsedLastTurn = false;
        target.takeDamage(attackPower);
        return name + " jabs for " + attackPower + " damage!";
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
        Polygon octagon = new Polygon();
        double size = 20;
        for (int i = 0; i < 8; i++) {
            double angle = 2 * Math.PI * i / 8;
            octagon.getPoints().addAll(
                40 + size * Math.cos(angle),
                40 + size * Math.sin(angle)
            );
        }
        octagon.setFill(Color.FORESTGREEN);
        return octagon;
    }
}