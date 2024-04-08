package mexer2.prog2.edu.slu;

/**
 * @author
 */
public class Circle extends Shape {
    private double radius;

    public Circle(String n, double r) {
        super(n);
        radius = r;
        sides = 0;
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
