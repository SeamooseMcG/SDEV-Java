public class TestRegularPolygon {
    public static void main(String[] args) {
        // Using no-arg constructor
        RegularPolygon polygon1 = new RegularPolygon();

        // Using constructor with 6 sides and side length 4
        RegularPolygon polygon2 = new RegularPolygon(6, 4);

        // Using constructor with 10 sides, side length 4, centered at (5.6, 7.8)
        RegularPolygon polygon3 = new RegularPolygon(10, 4, 5.6, 7.8);

        System.out.println("Polygon 1: sides = " + polygon1.getN() + ", side length = " + polygon1.getSide() +
                ", perimeter = " + polygon1.getPerimeter() + ", area = " + polygon1.getArea());

        System.out.println("Polygon 2: sides = " + polygon2.getN() + ", side length = " + polygon2.getSide() +
                ", perimeter = " + polygon2.getPerimeter() + ", area = " + polygon2.getArea());

        System.out.println("Polygon 3: sides = " + polygon3.getN() + ", side length = " + polygon3.getSide() +
                ", center = (" + polygon3.getX() + ", " + polygon3.getY() + ")" +
                ", perimeter = " + polygon3.getPerimeter() + ", area = " + polygon3.getArea());
    }
}