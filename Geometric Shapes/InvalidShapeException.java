package mexer2.prog2.edu.slu;

/**
 * Thrown to indicate that the application has tried to create a shape, but its
 * area or perimeter, or both, is negative or NaN.
 *
 * @author Mike Fajardo
 */
public class InvalidShapeException extends Exception {

    /**
     * Constructs a {@code InvalidShapeException} with no detail message.
     */
    public InvalidShapeException() {
        super();
    }

    /**
     * Constructs a {@code InvalidShapeException} with the specified detail message.
     */
    public InvalidShapeException(String s) {
        super(s);
    }
}
