public class RegularPolygon {
    // Private data fields
    private int n;          // Number of sides
    private double side;    // Length of side
    private double x;       // x-coordinate of center
    private double y;       // y-coordinate of center

    // No-arg constructor: default polygon with 3 sides, side length 1, centered at (0,0)
    public RegularPolygon() {
        this.n = 3;
        this.side = 1;
        this.x = 0;
        this.y = 0;
    }

    // Constructor with specified number of sides and side length, centered at (0,0)
    public RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
        this.x = 0;
        this.y = 0;
    }

    // Constructor with specified number of sides, side length, and center coordinates
    public RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    // Accessor and mutator methods
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Method to get perimeter: n * side
    public double getPerimeter() {
        return n * side;
    }

    // Method to get area using formula:
    // (n * side^2) / (4 * tan(PI / n))
    public double getArea() {
        return (n * side * side) / (4 * Math.tan(Math.PI / n));
    }
}