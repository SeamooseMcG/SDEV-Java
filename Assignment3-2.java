import java.math.BigInteger;
import java.util.Scanner;


public class TestRational {
  public static void main(String[] args) {
    // Prompt the user to enter two Rational numbers
    Scanner input = new Scanner(System.in);
    System.out.println("Enter rational r1 with numerator and denominator seperated by a space: ");
    String n1 = input.next();
    String d1 = input.next();

    System.out.println("Enter rational r2 with numerator and denominator seperated by a space: ");
    String n2 = input.next();
    String d2 = input.next();

    Rational r1 = new Rational(
      new BigInteger(n1), new BigInteger(d1));
    Rational r2 = new Rational(
      new BigInteger(n2), new BigInteger(d2));

    // Display results
    System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
    System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
    System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
    System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
    System.out.println(r2 + " is " + r2.doubleValue());
  }
}

public class Rational extends Number implements Comparable<Rational> {
  // Data fields for numerator and denominator
  public BigInteger numerator;
  public BigInteger denominator;

  /** Construct a rational with default properties */
  public Rational() {
    this(BigInteger.ZERO, BigInteger.ONE);
  }

  /** Construct a rational with specified numerator and denominator */
  public Rational(BigInteger numerator, BigInteger denominator) {
    BigInteger gcd = numerator.gcd(denominator);
    BigInteger sign = denominator.signum() > 0 ? BigInteger.ONE : BigInteger.valueOf(-1);
    this.numerator = sign.multiply(numerator).divide(gcd);
    this.denominator = denominator.abs().divide(gcd);
  }


  /** Return numerator */
  public BigInteger getNumerator() {
    return numerator;
  }

  /** Return denominator */
  public BigInteger getDenominator() {
    return denominator;
  }

  /** Add a rational number to this rational */
  public Rational add(Rational secondRational) {
    BigInteger n = numerator.multiply(secondRational.getDenominator())
                        .add(denominator.multiply(secondRational.getNumerator()));
    BigInteger d = denominator.multiply(secondRational.getDenominator());
    return new Rational(n, d);
  }

  /** Subtract a rational number from this rational */
  public Rational subtract(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator())
                          .subtract(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
    return new Rational(n, d);
  }

  /** Multiply a rational number to this rational */
  public Rational multiply(Rational secondRational) {
        return new Rational(
            numerator.multiply(secondRational.getNumerator()),
            denominator.multiply(secondRational.getDenominator())
        );
  }

  /** Divide a rational number from this rational */
  public Rational divide(Rational secondRational) {
        return new Rational(
            numerator.multiply(secondRational.getDenominator()),
            denominator.multiply(secondRational.getNumerator())
        );
  }

    @Override public int intValue() {
        return (int) doubleValue();
    }

    @Override public long longValue() {
        return (long) doubleValue();
    }

    @Override public float floatValue() {
        return (float) doubleValue();
    }

    @Override public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }


  @Override // Override toString()
  public String toString() {
    if (denominator.equals(BigInteger.ONE)) {
        return numerator.toString();
    }
    return numerator + "/" + denominator;
  }

  @Override // Override the equals method in the Object class 
  public boolean equals(Object other) {
        if (!(other instanceof Rational)) return false;
        Rational r = (Rational) other;
        return this.subtract(r).numerator.equals(BigInteger.ZERO);
  }

  @Override // Implement the compareTo method in Comparable
  public int compareTo(Rational other) {
        BigInteger lhs = this.numerator.multiply(other.denominator);
        BigInteger rhs = this.denominator.multiply(other.numerator);
        return lhs.compareTo(rhs);
    }
}


