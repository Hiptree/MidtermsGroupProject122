package mexer2.prog2.edu.slu;

/**
 * @author
 */
public class Square extends Shape {
    private double side;

    public Square(String name, double side) {
        super(name);
        this.side = side;
        sides = 4;
    }

    public double getSide() {
        return side;
    }

    public double area() {
        return side * side;
    }

    public double perimeter() {
        return side * 4;
    }
}
