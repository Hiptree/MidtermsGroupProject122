package GroupOfMike;


/**
 * The Fraction class represents a fraction with numerator and denominator attributes.
 *
 * This class contains constructors, setter and getter methods, and methods to
 * perform basic operations on fractions, such as arithmetic operations and
 * reducing a fraction to its simplest form. This class also includes methods
 * to represent a fraction as a String and as a double.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    /**
     * Constructs a fraction with default values of 0 as its numerator and 1 as its denominator.
     */
    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    /**
     * Constructs a fraction with the given numerator and denominator.
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Sets the numerator of the fraction.
     */
    public void setNumerator(int num) {
        numerator = num;
    }

    /**
     * Returns the numerator of the fraction.
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Sets the denominator of the fraction.
     */
    public void setDenominator(int den) {
        denominator = den;
    }

    /**
     * Returns the denominator of the fraction.
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Returns a string representation of the fraction as "numerator/denominator".
     *
     * If the denominator is 0, it returns "Undefined". If the denominator is negative,
     * both the numerator and denominator are multiplied by -1 so that a fraction
     * with a negative denominator will not be displayed as "numerator/-denominator,"
     * but "-numerator/denominator." For example, if the original fraction is 5/-9,
     * the fraction would be returned as a String as "-5/9".
     */
    @Override
    public String toString() {
        if (denominator == 0) {
            return "Undefined";
        } else if (denominator < 0) {
            int num = numerator * -1;
            int den = denominator * -1;
            return num + "/" + den;
        } else {
            return numerator + "/" + denominator;
        }
    }

    /**
     * Returns the value of the fraction as double.
     */
    public double toDouble() {
        return (double) numerator/denominator;
    }

    /**
     * Computes the greatest common divisor (GCD) of the numerator and denominator
     * of the fraction using Euclid's algorithm for calculating the GCD of two numbers.
     */
    private int computeGCD() {
        int x = numerator;
        int y = denominator;

        /*
        The larger number must be `x`. As such, if `y` is larger than `x`,
        then they swap values so the value of `x` is greater than `y`.
         */
        if (y > x) {
            int temp = x;
            x = y;
            y = temp;
        }

        /*
        This loop repeatedly takes the remainder of `x` divided by `y`,
        assigns `y` to `x`, and assigns the remainder to `y`, until the
        remainder (assigned to `y`) is zero. After the loop terminates,
        the last non-zero remainder (assigned to `x`) is the GCD.
         */
        while (y != 0) {
            int remainder = x % y;
            x = y;
            y = remainder;
        }
        int gCD = x;

        return gCD;
    }

    /**
     * Adds this fraction with the given fraction and returns the sum as a new Fraction.
     */
    public Fraction add(Fraction fraction2) {
        int sumNum = (numerator * fraction2.getDenominator()) + (fraction2.getNumerator() * denominator);
        int sumDen = denominator * fraction2.getDenominator();

        return new Fraction(sumNum, sumDen);
    }

    /**
     * Subtracts the given fraction from this fraction and returns the difference as a new Fraction.
     */
    public Fraction subtract(Fraction fraction2) {
        int diffNum = (numerator * fraction2.getDenominator()) - (fraction2.getNumerator() * denominator);
        int diffDen = denominator * fraction2.getDenominator();

        return new Fraction(diffNum, diffDen);
    }

    /**
     * Multiplies this fraction by the given fraction and returns the product as a new Fraction.
     */
    public Fraction multiplyBy(Fraction fraction2) {
        int productNum = numerator * fraction2.getNumerator();
        int productDen = denominator * fraction2.getDenominator();

        return new Fraction(productNum, productDen);
    }

    /**
     * Divides this fraction by the given fraction and returns the quotient as a new Fraction.
     *
     * If either the numerator or denominator of the second fraction is equal to 0, this method
     * returns a new Fraction (1/0) that results in Undefined. This is because when dividing
     * fractions, the reciprocal of the second fraction is used. If the numerator or denominator
     * of `fraction2` equals 0, then `fraction2` results in either 0 or undefined. `fraction1`
     * cannot be divided by 0 or undefined, as the result will be undefined indefinitely.
     */
    public Fraction divideBy(Fraction fraction2) {
        if (fraction2.getNumerator() == 0 || fraction2.getDenominator() == 0) {
            return new Fraction(1, 0);
        }

        int quotientNum = numerator * fraction2.getDenominator();
        int quotientDen = denominator * fraction2.getNumerator();

        return new Fraction(quotientNum, quotientDen);
    }

    /**
     * Simplifies the fraction to its simplest form by dividing both the
     * numerator and denominator by their greatest common divisor (GCD), then
     * returns the simplified fraction.
     *
     * In rare cases, a fraction might have both its numerator and denominator
     * as zero, resulting in a GCD of 0 which causes an exception. In this case,
     * the original fraction is returned as is (0/0 will be returned as 0/0).
     */
    public Fraction reduce() {
        int gCD = computeGCD();

        try {
            int num = numerator / gCD;
            int den = denominator / gCD;

            return new Fraction(num, den);
        } catch (Exception exception) {
            return new Fraction(numerator, denominator);
        }
    }
}