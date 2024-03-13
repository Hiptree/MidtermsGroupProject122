package prog2.prelim;

import java.util.InputMismatchException;
import java.util.Scanner;

class FractionArithmetic {

    public static void main(String[] args) {
        FractionArithmetic fractionArithmetic = new FractionArithmetic();

        try {
            fractionArithmetic.run();
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input. Please enter valid numeric values.");
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Fraction Arithmetic"); //introduction message prompt
        while (true) {
            System.out.println("Press Enter to continue: ");
            try{
                System.in.read();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("--------------------------");
            System.out.println("What do you want to do?");
            System.out.println("1. Add fractions");
            System.out.println("2. Subtract fractions");
            System.out.println("3. Multiply fractions");
            System.out.println("4. Divide fractions");
            System.out.println("5. Reduce a fraction");
            System.out.println("6. Quit");
            System.out.println("--------------------------");

            System.out.print("Enter Operation Here: ");

            /*
             * code below initiates the operation choices.
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
                System.out.println("Simplified Form: " +fraction.simplify());
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

    /*below is a method used to get the value of the fractions via user input
     * if the user inputs a non-numerical value or 0, it repeats the prompt until the user
     * inputs something valid
     *
     * */
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

    private void fractionOperation(int choice, Fraction fraction1, Fraction fraction2){
        switch (choice) {
            case 1 -> {
                System.out.println("Sum: " + fraction1.add(fraction2)); //display the computed value
                System.out.println("Lowest Term:  " + fraction1.add(fraction2).simplify()); //display the simplified fraction
                System.out.printf("Whole Number Equivalent: %.2f", fraction1.add(fraction2).convertWholeNumber());// display the whole number equivalent with the first 2 decimal digits.
                System.out.println();
            }
            case 2 -> {
                System.out.println("Difference: " + fraction1.subtract(fraction2));//case for the subtraction operation
                System.out.println("Lowest Term:  " + fraction1.subtract(fraction2).simplify()); //display the simplified fraction
                System.out.printf("Whole Number Equivalent: %.2f", fraction1.subtract(fraction2).convertWholeNumber());
                System.out.println();
            }
            case 3 -> {
                System.out.println("Product: " + fraction1.multiplyBy(fraction2));
                System.out.println("Lowest Term: " + fraction1.multiplyBy(fraction2).simplify());
                System.out.printf("Whole Number Equivalent: %.2f", fraction1.multiplyBy(fraction2).convertWholeNumber());
                System.out.println();
            }
            case 4 -> {
                System.out.println("Quotient: " + fraction1.divideBy(fraction2));
                System.out.println("Lowest Term: " + fraction1.divideBy(fraction2).simplify());
                System.out.printf("Whole Number Equivalent: %.2f", fraction1.divideBy(fraction2).convertWholeNumber());
                System.out.println();
            }
            default -> System.out.println("Invalid Choice!"); //actual code later
        }//end of switch-case
    }//end of fractionOperation

}//end of class
