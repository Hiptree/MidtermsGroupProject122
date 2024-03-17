package CombinedCodes;
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
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input. Please enter valid numeric values.");
        }
    }//end of main method
    
     /**
     * Runs the program and provides a menu for the user to select the operations they want.
     * It also handles input exceptions and loops the part of the program's prompt where 
     the exception occurred until a valid input has been entered.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Fraction Arithmetic"); //introduction message prompt
        while (true) {
            System.out.println("Press Enter to continue: ");
            try {
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("""
                ———MENU—————————————————————
                   [1] Add fractions
                   [2] Subtract fractions
                   [3] Multiply fractions
                   [4] Divide fractions
                   [5] Reduce a fraction
                   [6] Quit
                ————————————————————————————""");

            /*
             * The block of ode below initiates the operation choices.
             * it also loops the prompt if the user inputs something that is not among
             * the options.
             *
             *
             * might not be needed if the operands are on another method
             * */
            int choice;
            try {
                choice = scanner.nextInt();
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for choice. Please enter a number.");
                scanner.next(); // Clear the invalid input
                continue;
            } if (choice < 1 || choice > 6) {
                System.out.println("Enter a valid number!");
                System.out.print("Enter Operation Here: ");
                scanner.next(); // Clear the invalid input
                continue;

            }
            else if (choice == 6) {
                System.out.println("Exiting program. Goodbye!");
                System.exit(0);
                break;
            } else if (choice == 5){ // choice 5 will reduce a fraction so it only needs 1 input of fraction.
                System.out.println("Enter the fraction you want to simplify: ");
                Fraction fraction = getFractionFromUser();
                System.out.println("Simplified Form: " +fraction.reduce());
                System.out.println();
                run();
            }
            //input for fraction
            System.out.println("Enter the first fraction:");
            Fraction fraction1 = getFractionFromUser();
            System.out.println();
            System.out.println("Enter the second fraction:");
            Fraction fraction2 = getFractionFromUser();
            System.out.println();
            fractionOperation(choice, fraction1, fraction2);
            System.out.println("---------------------------------");
        }

    }//end of run

  /* The method below gets the values for the fractions needed for the selected operation.
  * Like the run method, it also validates if the input for the whole number, denominator, or numerator
  * are valid and loops the part of the prompt where an invalid input was made.
  */
   private Fraction getFractionFromUser() {
        Scanner scanner = new Scanner(System.in);

        int wholeNumber = 0;
        int numerator = 0;
        int denominator = 1;
        
        //prompt with an option for the user to input a mixed fraction
       while (true) {
            try {
                // Ask the user if they want to input a mixed fraction
                System.out.print("Do you want to input a mixed fraction? (yes/no): ");
                String choice = scanner.next().toLowerCase();

                // Validate user input
                if (!choice.equals("yes") && !choice.equals("no")) {
                    throw new InputMismatchException(); // Throw exception for invalid choice
                }

                // prompt for the whole number part if user wants to input a mixed fraction,
                if (choice.equals("yes")) {
                    // Input for whole number
                    while (true) {
                        try {
                            System.out.print("Enter the whole number part: ");
                            wholeNumber = scanner.nextInt();
                            break; // Exit the loop if input is valid
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input for whole number. Please enter a valid numeric value.");
                            scanner.nextLine(); // Clear the invalid input
                        }
                    }
                }
                break; // Exits the loop if choice input is valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                scanner.nextLine(); // Clears the invalid input
            }
        }

        // Input for numerator
        while (true) {
            try {
                System.out.print("Enter numerator: ");
                numerator = scanner.nextInt();
                break; // Exits the loop if the input is valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for numerator. Please enter a valid numeric value.");
                scanner.nextLine(); // Clears the invalid input
            }
        }

        // Input for denominator
        while (true) {
            try {
                System.out.print("Enter denominator: ");
                denominator = scanner.nextInt();
                if (denominator != 0) {
                    break; // Exits the loop if the input is valid and not equal to zero
                } else {
                    System.out.println("Denominator cannot be zero. Please enter a non-zero value.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for denominator. Please enter a valid numeric value.");
                scanner.nextLine(); // Clears the invalid input
            }
        }

        //converts a mixed fraction into regular fraction before returning the value
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
    *Performs the operation selected by the user and displays the result
    *The first case is addition.
    *The second case is subtraction.
    *The third case is multiplication.
    *The fourth case is division.
    *The reducement operation is on the run method.
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
