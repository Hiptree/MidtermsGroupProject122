package GroupOfMike;


import java.util.*;

/**
 * This main class allows a user perform basic operations on fractions through a command-line program.
 */
public class FractionArithmetic {
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        FractionArithmetic ourProgram;

        try {
            ourProgram = new FractionArithmetic();
            ourProgram.run();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * This method runs a loop that displays the program menu, prompts the user
     * to enter a choice from the menu, performs the corresponding operation,
     * and displays the result as a fraction and its decimal equivalent to the
     * console. If the user enters 6 as the choice, the program terminates.
     */
    public void run() {
        while (true) {
            System.out.println();
            printMenu();
            int choice = readInteger("Enter choice: ", 1, 6);

            if (choice == 6) {
                System.exit(0);
            } else {
                Fraction result;
                result = performOperation(choice);
                System.out.println("\nResult is equal to " + result + " or " + result.toDouble() + ".");
            }
        }
    }

    /**
     * Prints the menu to the console.
     */
    public void printMenu() {
        System.out.println("""
                ———MENU—————————————————————
                   [1] Add fractions
                   [2] Subtract fractions
                   [3] Multiply fractions
                   [4] Divide fractions
                   [5] Reduce a fraction
                   [6] Quit
                ————————————————————————————""");
    }

    /**
     * Reads an integer from the console.
     *
     * Accepts an integer value only, which must not be less than the minimum
     * value or greater than the maximum value specified. Otherwise, the user
     * is repeatedly prompted for an integer until a valid value is entered.
     */
    public int readInteger(String prompt, int min, int max) {
        boolean isValid = false;
        int choice = 0;

        while (!isValid) {
            try {
                System.out.print(prompt);
                choice = Integer.parseInt(keyboard.nextLine());

                if (choice < min || choice > max) {
                    System.out.println("Please enter a number from " + min + " to " + max + " only.");
                } else {
                    isValid = true;
                }
            } catch (NumberFormatException nFE) {
                System.out.println("Uh-oh! You must enter an integer.");
            }
        }
        return choice;
    }

    /**
     * Reads values of the numerator and denominator from the console, then
     * returns a new Fraction object with the given numerator and denominator.
     *
     * The values of the numerator and denominator must be integers and not less
     * than `Integer.MIN_VALUE` or greater than `Integer.MAX_VALUE`. Otherwise, the
     * user is prompted repeatedly until a valid value is entered.
     */
    public Fraction readFraction(String prompt) {
        System.out.println("\n" + prompt);
        int numerator = (readInteger("Numerator: ", Integer.MIN_VALUE, Integer.MAX_VALUE));
        int denominator = (readInteger("Denominator: ", Integer.MIN_VALUE, Integer.MAX_VALUE));

        return new Fraction(numerator, denominator);
    }

    /**
     * Performs a fraction operation based on the given choice. The result is
     * reduced to its simplest form before being returned.
     *
     * This method takes an int as an argument, assigned to `choice`. If `choice`
     * is equal to 5, this method reads a fraction from the console and reduces
     * it to its simplest form. Otherwise, this method reads two fractions from
     * the console and performs the corresponding arithmetic operation.
     */
    public Fraction performOperation(int choice) {
        Fraction result = new Fraction();

        if (choice == 5) {
            Fraction fracToReduce = readFraction("Enter fraction");

            result = fracToReduce.reduce();
        } else {
            Fraction fraction1 = readFraction("Enter fraction 1");
            Fraction fraction2 = readFraction("Enter fraction 2");

            switch (choice) {
                case 1:
                    result = fraction1.add(fraction2);
                    break;
                case 2:
                    result = fraction1.subtract(fraction2);
                    break;
                case 3:
                    result = fraction1.multiplyBy(fraction2);
                    break;
                case 4:
                    result = fraction1.divideBy(fraction2);
                    break;
            }
        }
        return result.reduce();
    }
}

