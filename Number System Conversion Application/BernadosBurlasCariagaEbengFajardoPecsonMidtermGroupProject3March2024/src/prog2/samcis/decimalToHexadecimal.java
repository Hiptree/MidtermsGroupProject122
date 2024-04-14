/**
     * This method converts decimal to hexadeimal.
     * Since we utilized arrays in this method, it is better to have the return type void
     * to easily print it already inside the method.
     *
     * @param decimal The decimal to be converted
     * @author Gerard Bernados
     */
public static void decimalToHexadecimal(double decimal) {

            int wholeNumber = (int) decimal;
            double fractionPart = getFraction(decimal);
            // set the array sizes to 100 to hold 100 digits
            int[] wholeNumberPart = new int[100];
            int[] fractionalPart = new int[100];

            /*
            to convert decimal fraction to hexadecimal, the whole number must be divided into the
            base, in this situation, the base is 16. While the remainder is the hexadecimal equivalent itself
             */

            // Convert whole number part to hexadecimal
            int i = 0;
            // loop until the number we are dividing is not equal to 0
            while (wholeNumber != 0) {
                // initialize the first digit of hexadecimal to the modulo of whole number
                wholeNumberPart[i++] = wholeNumber % 16;
                wholeNumber /= 16; // change the whole number variable to the quotient when divided by the base
            }

            /*
            to convert the fractional part of decimal, we must multiply it by the base. In this situation, the base is
            16. The whole number part of the resulting product is the digit of the hexadecimal fraction part itself
             */

            // Convert fractional part to hexadecimal
            int j = 0;
            // loop until the fraction part is not equal to 0
            while (fractionPart != 0) {
                fractionPart *= 16; //multiply by 16 and assign the result to the variable
                // populate the array by the resulting whole number from the product
                fractionalPart[j++] = (int) fractionPart;
                fractionPart %= 1; // get the module to remove any whole number part in the variable
            }

            // Print hexadecimal number array (whole number part)
            for (int k = i - 1; k >= 0; k--) {
                if (wholeNumberPart[k] > 9) // this will allow to print the hexadecimal digits
                    // addition of 55 to comply with the lexicographical arrangement of the unicode character
                    System.out.print((char) (55 + wholeNumberPart[k]));
                else
                    System.out.print(wholeNumberPart[k]);
            }

            // Print hexadecimal number array (fractional part)
            System.out.print(".");
            for (int k = 0; k < j; k++) {
                if (fractionalPart[k] > 9) // this will allow to print the hexadecimal digits
                    // addition of 55 to comply with the lexicographical arrangement of the unicode character
                    System.out.print((char) (55 + fractionalPart[k]));
                else
                    System.out.print(fractionalPart[k]);
            }
        }

        public static double getFraction(double n) {
            return n - (int) n;
        }
