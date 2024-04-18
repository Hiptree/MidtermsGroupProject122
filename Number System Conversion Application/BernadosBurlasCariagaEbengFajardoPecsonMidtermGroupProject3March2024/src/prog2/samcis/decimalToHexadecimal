/**
     * This method converts hexadecimal to decimal
     *
     * @param hexadecimal The hexadecimal to be converted
     * @author Gerard Bernados
     */
        public static double hexadecimalToDecimal (String hexadecimal) {

            //initialize the length of digits assuming that it has no fractional part
            int length = hexadecimal.length();
            int wholeNumber = 0;
            double fractionPart = 0;

            // to execute specific statements if the actual parameter has a fractional part
            boolean isFractional = false;

            //to determine where to split the whole number and fraction part
            int decimalPosition = hexadecimal.indexOf('.');
            // when the index of '.' is not to -1, then it has a fractional part.
            if (decimalPosition != -1) {
                isFractional = true;
                length = decimalPosition; // declaring the length of whole number part only
            }

             /*
            to convert decimal to hexadecimal, we must multiply the whole number part
            by 16 to the increasing power from 1 and so on.
             */

            for (int i = length - 1; i >= 0; i--) {
                char c = hexadecimal.charAt(i);
                int digitValue;
                if (Character.isDigit(c)) { //this method determines of that character in that index is a digit or not
                    digitValue = c - '0'; // allows the digit to be a string
                } else {
                    // in here, we minus it to a character A, which is in ASCII value is 65
                    // we add it to 10 to represent the Hexadecimal letters (i.e A = 10, B = 11, and so on)
                    digitValue = Character.toUpperCase(c) - 'A' + 10;
                }
                wholeNumber += digitValue * Math.pow(16, length - 1 - i); // this will start from the power of 0
            }

             /*
            to convert the fractional part of decimal to hexadecimal, we must multiply the whole number part
            by 16 to the decreasing power from -1 and so on.
             */

            if (isFractional) {
                for (int i = decimalPosition + 1; i < hexadecimal.length(); i++) {
                    char c = hexadecimal.charAt(i);
                    int digitValue;
                    if (Character.isDigit(c)) {
                        digitValue = c - '0';
                    } else {
                        digitValue = Character.toUpperCase(c) - 'A' + 10;
                    }
                    fractionPart += digitValue * Math.pow(16, decimalPosition - i); //this will start from the power of -1
                }
            }

            return wholeNumber + fractionPart;
        }
