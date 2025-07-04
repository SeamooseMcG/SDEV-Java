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