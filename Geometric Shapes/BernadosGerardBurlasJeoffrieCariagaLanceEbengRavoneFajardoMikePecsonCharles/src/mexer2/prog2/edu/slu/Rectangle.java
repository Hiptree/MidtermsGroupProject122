package mexer2.prog2.edu.slu;

/**
 * @author Ravone Ebeng
 */
public class Rectangle extends Square {
    private double side2;

    public Rectangle(String name, double side1, double side2) {
        super(name, side1);
        this.side2 = side2;
        sides = 4;
    }

    public double area() {
        return super.getSide() * side2;
    }

    public double perimeter() {
        return 2 * super.getSide() + 2 * side2;
    }
}
