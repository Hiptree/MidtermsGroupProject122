package mexer2.prog2.edu.slu;

public abstract class Shape {
    private String name;
    protected int sides;

    public Shape(String n) {
        name = n;
    }

    public String toString() {
        return name + " with " + sides + " sides.";
    }

    public int getSides() {
        return sides;
    }

    public abstract double area();
    public abstract double perimeter();
}
