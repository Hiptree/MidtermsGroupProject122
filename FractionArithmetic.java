package CombinedCodes;
import java.util.*;


/**
 * This main class allows a user to perform basic operations on fractions through a command-line program.
 * It also handles any exceptions that may occur during the program's execution.
 */
public class FractionArithmetic {
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        FractionArithmetic ourProgram;

        try {
            //creates an instance of FractionArithmethic
            ourProgram = new FractionArithmetic();
            ourProgram.run();
        } catch (InputMismatchException ex) {
                    // Handle InputMismatchException if it occurs
            System.out.println("Invalid input. Please enter valid numeric values.");
        }
    }//end of main method
    
 /**
 * Runs the Fraction Arithmetic program, allowing the user to perform operations on fractions.
 * This method displays a menu, prompts the user to choose whether to use mixed fractions or not,
 * and handles the user input for performing fraction operations.
 */
public void run() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to Fraction Arithmetic");

    while (true) {
        // Prompt the user to choose whether to use mixed fractions or not
        System.out.print("Do you want to perform operations on mixed fractions? (yes/no): ");
        String choiceMixed = scanner.next().toLowerCase();
        boolean useMixedFractions = choiceMixed.equals("yes");

        // Prompt the user to press Enter to continue
        System.out.println("Press Enter to continue: ");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Display the menu for fraction operations
        System.out.println("""
            ———MENU—————————————————————
               [1] Add fractions
               [2] Subtract fractions
               [3] Multiply fractions
               [4] Divide fractions
               [5] Reduce a fraction
               [6] Quit
            ————————————————————————————""");
        System.out.print("Enter here: ");

        int choice = 0;
        try {
            choice = scanner.nextInt();
            System.out.println();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for choice. Please enter a number.");
            scanner.next(); // Clear the invalid input
            continue;
        }

        // Check if the choice is valid
        if (choice < 1 || choice > 6) {
            System.out.println("Enter a valid number!");
            continue;
        } else if (choice == 6) {
            // Exit the program if the user chooses to quit
            System.out.println("Exiting program. Goodbye!");
            System.exit(0);
        } else if (choice == 5) {
            // Perform fraction reduction if the user chooses option 5
            System.out.println("Enter the fraction you want to simplify: ");
            Fraction fraction = getFractionFromUser(useMixedFractions);
            System.out.println("Simplified Form: " + fraction.reduce());
            System.out.println();
            continue;
        }

        // Prompt the user to enter the first fraction
        System.out.println("Enter the first fraction:");
        Fraction fraction1 = getFractionFromUser(useMixedFractions);
        System.out.println();

        // Prompt the user to enter the second fraction
        System.out.println("Enter the second fraction:");
        Fraction fraction2 = getFractionFromUser(useMixedFractions);
        System.out.println();

        // Perform the selected fraction operation
        fractionOperation(choice, fraction1, fraction2);
        System.out.println("---------------------------------");
    }
}//end of run method


   /**
     * Prompts the user to input a fraction, either as a regular fraction or a mixed fraction, based on value of the boolean useMixedFractions on the run method
     * If useMixedFractions is true, the method prompts the user to input a mixed fraction.
     * If useMixedFractions is false, the method prompts the user to input a regular fraction.
     *
     * @param useMixedFractions indicates whether to prompt for a mixed fraction or a regular fraction 
     * @return the fraction that is inputted is returned
     *Like the run method, it also validates if the input for the whole number, denominator, or numerator
     * are valid and loops the part of the prompt where an invalid input was made.
    */
    private Fraction getFractionFromUser(boolean useMixedFractions) {
        Scanner scanner = new Scanner(System.in);

        int wholeNumber = 0;
        int numerator;
        int denominator;

        // Prompt for the whole number if the fractions are going to be mixed fractions
        if (useMixedFractions) {
            while (true) {
                try {
                    System.out.print("Enter the whole number part: ");
                    wholeNumber = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input for whole number. Please enter a valid numeric value.");
                    scanner.nextLine(); // Clear the invalid input
                }
            }
        }

        // Prompt for numerator
        while (true) {
            try {
                System.out.print("Enter the numerator: ");
                numerator = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for numerator. Please enter a valid numeric value.");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        // Prompt for denominator
        while (true) {
            try {
                System.out.print("Enter the denominator: ");
                denominator = scanner.nextInt();
                if (denominator != 0) {
                    break;
                } else {
                    System.out.println("Denominator cannot be zero. Please enter a non-zero value.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for denominator. Please enter a valid numeric value.");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        // Convert a mixed fraction into a regular fraction before returning the value
        try {
            if (wholeNumber != 0) {
                return new Fraction(wholeNumber * denominator + numerator, denominator);
            } else {
                return new Fraction(numerator, denominator);
            }
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage()); // Handle division by zero
            return null;
        }
    }//end of getFractionFromUser method
    
    /**
    *The fractionOperation method [erforms the operation selected by the user and displays the result
    *The first case is addition.
    *The second case is subtraction.
    *The third case is multiplication.
    *The fourth case is division.
    *The reducement operation is on the run method.
    *Reducement is not on this method but exists as an else-if statement on the run method that is used by the program if the user selects
    *the 5th option (reducement) in the operation selection menu
    * @param fraction1 The first fraction involved in the operation
    * @param fraction2 The second fraction involved in the operation
    */
    private void fractionOperation(int choice, Fraction fraction1, Fraction fraction2){
        switch (choice) {
            case 1 -> {
                System.out.println("Sum: " + fraction1.add(fraction2)); //display the computed value
                System.out.println("Lowest Term:  " + fraction1.add(fraction2).reduce()); //display the simplified fraction
                System.out.printf("Whole Number Equivalent: %.2f", fraction1.add(fraction2).toDouble());// display the whole number equivalent with the first 2 decimal digits.
                System.out.println();
            }
            case 2 -> {
                System.out.println("Difference: " + fraction1.subtract(fraction2));//case for the subtraction operation
                System.out.println("Lowest Term:  " + fraction1.subtract(fraction2).reduce()); //display the simplified fraction
                System.out.printf("Whole Number Equivalent: %.2f", fraction1.subtract(fraction2).toDouble());
                System.out.println();
            }
            case 3 -> {
                System.out.println("Product: " + fraction1.multiplyBy(fraction2));
                System.out.println("Lowest Term: " + fraction1.multiplyBy(fraction2).reduce());
                System.out.printf("Whole Number Equivalent: %.2f", fraction1.multiplyBy(fraction2).toDouble());
                System.out.println();
            }
            case 4 -> {
                System.out.println("Quotient: " + fraction1.divideBy(fraction2));
                System.out.println("Lowest Term: " + fraction1.divideBy(fraction2).reduce());
                System.out.printf("Whole Number Equivalent: %.2f", fraction1.divideBy(fraction2).toDouble());
                System.out.println();
            }
            default -> System.out.println("Invalid Choice!"); //actual code later
        }//end of switch-case
    }//end of fractionOperation
}//end of class
