public class Triangle extends GeometricObject {
    
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;
    

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3,
        String color, boolean filled){
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
    setColor(color);
    setFilled(filled);
    }


    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    @Override 
    public double getPerimeter(){
        return side1 + side2 + side3;
    }

    @Override 
    public double getArea(){
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    
     @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3;
  }
}

import java.util.Scanner;

public class TestTriangle {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Prompt user
    System.out.print("Enter the lenghts of the three sides of the triangle: ");
    double side1 = input.nextDouble();
    double side2 = input.nextDouble();
    double side3 = input.nextDouble();

    System.out.print("Give it a color: ");
    String color = input.next();

    System.out.print("Is the triangle filled? (true/false): ");
    boolean filled = input.nextBoolean();

    // Create triangle object
    Triangle triangle = new Triangle(side1, side2, side3, color, filled);

    // Display results
    System.out.println("\nTriangle details:");
    System.out.println(triangle);
    System.out.println("Area: " + triangle.getArea());
    System.out.println("Perimeter: " + triangle.getPerimeter());
    System.out.println("Color: " + triangle.getColor());
    System.out.println("Filled: " + triangle.isFilled());
  }
}

