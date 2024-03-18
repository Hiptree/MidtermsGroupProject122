package CombinedCodes;
import java.util.*;


/**
 * This main class allows a user to perform basic operations on fractions through a command-line program.
 * It also handles any exceptions that may occur during the program's execution.
 */
public class FractionArithmetic {

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
            // Prompt the user to press Enter to continue
            System.out.println("Press Enter to continue: ");
            try {
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Prompt the user to choose whether to use mixed fractions or not
            System.out.print("Do you want to perform operations on mixed fractions? (Type yes or no): ");
            String choiceMixed = scanner.next().toLowerCase();

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
            } else if (choiceMixed.equals("no") && choice <=4 ){
                // Prompt the user to enter the first fraction
                System.out.println("Enter the first fraction:");
                Fraction fraction1 = getFractionFromUser();
                System.out.println();

                // Prompt the user to enter the second fraction
                System.out.println("Enter the second fraction:");
                Fraction fraction2 = getFractionFromUser();
                System.out.println();

                // Perform the selected fraction operation
                fractionOperation(choice, fraction1, fraction2);
                System.out.println("---------------------------------");

            } else if (choiceMixed.equals("yes") && choice <=4){

                // Prompt the user to enter the first fraction
                System.out.println("Enter the first fraction:");
                MixedFraction fraction1 = getMixedFractionFromUser();
                System.out.println();

                // Prompt the user to enter the second fraction
                System.out.println("Enter the second fraction:");
                MixedFraction fraction2 = getMixedFractionFromUser();
                System.out.println();

                // Perform the selected fraction operation
                mixedFractionOperation(choice, fraction1, fraction2);
                System.out.println("---------------------------------");


            } else if (choice == 6) {
                // Exit the program if the user chooses to quit
                System.out.println("Exiting program. Goodbye!");
                System.exit(0);

            } else if (choice == 5 && choiceMixed.equals("no")) {
                // Perform fraction reduction if the user chooses option 5
                System.out.println("Enter the fraction you want to simplify: ");
                Fraction fraction = getFractionFromUser();
                System.out.println("Simplified Form: " + fraction.reduce());
                System.out.println();


            } else if (choice == 5 && choiceMixed.equals("yes")){
                // Perform fraction reduction if the user chooses option 5
                System.out.println("Enter the mixed fraction you want to simplify: ");
                MixedFraction fraction = getMixedFractionFromUser();
                System.out.println("Simplified Form: " + fraction.toFraction().reduce().toMixedFraction());
                System.out.println();

            }

        }
    }//end of run method


    /**
     * Prompts the user to input a fraction, either as a regular fraction or a mixed fraction, based on value of the boolean useMixedFractions on the run method
     * If useMixedFractions is true, the method prompts the user to input a mixed fraction.
     * If useMixedFractions is false, the method prompts the user to input a regular fraction.
     *
     *
     * @return the mixed fraction that is inputted is returned
     *Like the run method, it also validates if the input for the whole number, denominator, or numerator
     * are valid and loops the part of the prompt where an invalid input was made.
     */
    private MixedFraction getMixedFractionFromUser() {
        Scanner scanner = new Scanner(System.in);

        int numerator, denominator, wholeNumber;

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
        //numerator
        while (true) {
            try {
                System.out.print("Enter numerator: ");
                numerator = scanner.nextInt();
                break; // Exit the loop if input is valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for numerator. Please enter a valid numeric value.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        //denominator
        while (true) {
            try {
                System.out.print("Enter denominator: ");
                denominator = scanner.nextInt();
                if (denominator != 0) {
                    break; // Exit the loop if input is valid and not equal to zero
                } else {
                    System.out.println("Denominator cannot be zero. Please enter a non-zero value.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for denominator. Please enter a valid numeric value.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        return new MixedFraction(wholeNumber, numerator, denominator);
    }//end of getFractionFromUser
    
    /**
     * Prompts the user to input a fraction, either as a regular fraction or a mixed fraction, based on value of the boolean useMixedFractions on the run method
     * If useMixedFractions is true, the method prompts the user to input a mixed fraction.
     * If useMixedFractions is false, the method prompts the user to input a regular fraction.
     *
     *
     * @return the fraction that is inputted is returned
     *Like the run method, it also validates if the input for the denominator or numerator
     * are valid and loops the part of the prompt where an invalid input was made.
     */
    private Fraction getFractionFromUser() {
        Scanner scanner = new Scanner(System.in);

        int numerator, denominator;

        //numerator
        while (true) {
            try {
                System.out.print("Enter numerator: ");
                numerator = scanner.nextInt();
                break; // Exit the loop if input is valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for numerator. Please enter a valid numeric value.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        //denominator
        while (true) {
            try {
                System.out.print("Enter denominator: ");
                denominator = scanner.nextInt();
                if (denominator != 0) {
                    break; // Exit the loop if input is valid and not equal to zero
                } else {
                    System.out.println("Denominator cannot be zero. Please enter a non-zero value.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for denominator. Please enter a valid numeric value.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        return new Fraction(numerator, denominator);
    }//end of getFractionFromUser

    /**
     *The fractionOperation method performs the operation selected by the user and displays the result
     *The first case is addition.
     *The second case is subtraction.
     *The third case is multiplication.
     *The fourth case is division.
     *The reducement operation is on the run method.
     *Reducement is not on this method but exists as an else-if statement on the run method that is used by the program if the user selects
     *the 5th option (reducement) in the operation selection menu
     * @param choice
     * @param fraction1 The first fraction involved in the operation
     * @param fraction2 The second fraction involved in the operation
     */
    private void fractionOperation(int choice, Fraction fraction1, Fraction fraction2){
        switch (choice) {
            case 1 -> {
                System.out.println("Sum: " + fraction1.add(fraction2)); //display the computed value
                System.out.println("Lowest Term:  " + fraction1.add(fraction2).reduce()); //display the simplified fraction
                System.out.printf("Decimal Equivalent: %.2f", fraction1.add(fraction2).toDouble());// display the whole number equivalent with the first 2 decimal digits.
                System.out.println();
            }
            case 2 -> {
                System.out.println("Difference: " + fraction1.subtract(fraction2));//case for the subtraction operation
                System.out.println("Lowest Term:  " + fraction1.subtract(fraction2).reduce()); //display the simplified fraction
                System.out.printf("Decimal Equivalent: %.2f", fraction1.subtract(fraction2).toDouble());
                System.out.println();
            }
            case 3 -> {
                System.out.println("Product: " + fraction1.multiplyBy(fraction2));
                System.out.println("Lowest Term: " + fraction1.multiplyBy(fraction2).reduce());
                System.out.printf("Decimal Equivalent: %.2f", fraction1.multiplyBy(fraction2).toDouble());
                System.out.println();
            }
            case 4 -> {
                System.out.println("Quotient: " + fraction1.divideBy(fraction2));
                System.out.println("Lowest Term: " + fraction1.divideBy(fraction2).reduce());
                System.out.printf("Decimal Equivalent: %.2f", fraction1.divideBy(fraction2).toDouble());
                System.out.println();
            }
            default -> System.out.println("Invalid Choice!"); //actual code later
        }//end of switch-case
    }//end of fractionOperation

    /**
     *The mixedFractionOperation method performs the operation selected by the user and displays the result
     *The first case is addition.
     *The second case is subtraction.
     *The third case is multiplication.
     *The fourth case is division.
     *The reducement operation is on the run method.
     *Reducement is not on this method but exists as an else-if statement on the run method that is used by the program if the user selects
     *the 5th option (reducement) in the operation selection menu
     * @param choice
     * @param fraction1 The first fraction involved in the operation
     * @param fraction2 The second fraction involved in the operation
     */
    private void mixedFractionOperation(int choice, MixedFraction fraction1, MixedFraction fraction2){
        switch (choice) {
            case 1 -> {
                System.out.println("Sum: " + fraction1.add(fraction2)); //display the computed value
                System.out.println("Improper Fraction: " + fraction1.add(fraction2).toFraction()); //display the simplified fraction
                System.out.printf("Decimal Equivalent: %.2f", fraction1.add(fraction2).toFraction().toDouble());// display the whole number equivalent with the first 2 decimal digits.
                System.out.println();
            }
            case 2 -> {
                System.out.println("Difference: " + fraction1.subtract(fraction2));//case for the subtraction operation
                System.out.println("Improper Fraction: " + fraction1.subtract(fraction2).toFraction()); //display the simplified fraction
                System.out.printf("Decimal Equivalent: %.2f", fraction1.subtract(fraction2).toFraction().toDouble());
                System.out.println();
            }
            case 3 -> {
                System.out.println("Product: " + fraction1.multiplyBy(fraction2).reduce().toMixedFraction());
                System.out.println("Improper Fraction: " + fraction1.multiplyBy(fraction2).reduce());
                System.out.printf("WDecimal Equivalent: %.2f", fraction1.multiplyBy(fraction2).toDouble());
                System.out.println();
            }
            case 4 -> {
                System.out.println("Quotient: " + fraction1.divideBy(fraction2).reduce().toMixedFraction());
                System.out.println("Improper Fraction: " + fraction1.divideBy(fraction2).reduce());
                System.out.printf("Decimal Equivalent: %.2f", fraction1.divideBy(fraction2).toDouble());
                System.out.println();
            }
            default -> System.out.println("Invalid Choice!"); //actual code later
        }//end of switch-case
    }//end of fractionOperation
}//end of class
