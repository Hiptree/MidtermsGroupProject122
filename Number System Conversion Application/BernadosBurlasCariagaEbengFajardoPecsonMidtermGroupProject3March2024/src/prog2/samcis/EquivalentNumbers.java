/**
 Name/s of programmer:
 Class Code and Schedule:
 Date:
 */
package prog2.samcis;
/**
 *A template for an object representing a whole number with its decimal, binary, octal and hexadecimal form.
 **/
public class EquivalentNumbers implements NumberConverter {
    private int decimalNumber; // decimal number form
    private String hexadecimalString; // hexadecimal number form
    private String binaryString; // binary number form
    private String octalString; // octal number form
    /**
     *Constructs an object representing the number 0
     **/
    public EquivalentNumbers(){
        decimalNumber=0;
        hexadecimalString="0";
        binaryString="0";
        octalString="0";
    }

    /**
     *Constructs an object representing a q whole number a
     **/
    public EquivalentNumbers(int a, String b, String c, String d){
        decimalNumber=a;
        hexadecimalString=b;
        binaryString=c;
        octalString=d;
    }
    /**
     *Returns the decimal number form of an object of EquivalentNumbers
     **/
    public long getDecimalNumber(){
        return decimalNumber;
    }

    /**
     *Returns the hexadecimal number form of an object of EquivalentNumbers
     **/
    public String getHexadecimalString(){
        return hexadecimalString;
    }
    /**
     *Returns the binary number form of an object of EquivalentNumbers
     **/
    public String getBinaryString(){
        return binaryString;
    }
    /**
     *Returns the octal number form of an object of EquivalentNumbers
     **/
    public String getOctalString(){
        return octalString;
    }

    /**
     *Sets the hexadecimal number string to n, then the decimal number, binary number and octal number
     *are set based on the hexadecimal number.
     */
    public void setHexadecimalString(String n){
        hexadecimalString = n;
        decimalNumber = hexadecimalToDecimal(hexadecimalString);
/* 2. Assign the decimal string, binary string, and octal string that is equivalent to the hexadecimal string n
by invoking/calling the methods that you must have created */
        decimalString = _________________________________;
        binaryString = __________________________________;
        octalString = ____________________________________;

    }

    /**
     *Sets the octal number string to n, then the decimal number, binary number and hexadecimal number
     *are set based on the octal number.
     */
    public void setOctalString(String n){
        octalString = n;
/* 3. Assign the decimal string, binary string, and hexadecimal string that is equivalent to the octal string n
by invoking/calling the methods that you must have created */
        decimalString = _________________________________;
        binaryString = __________________________________;
        hexadecimalString = ____________________________________;
    }

    /**
     *Sets the binary number string to n, then the decimal number, octal number and hexadecimal number
     *are set based on the binary number.
     */
    public void setBinaryString(String b) throws Exception{
        binaryString = b;
/* 4. Assign the decimal string, octal string, and hexadecimal string that is equivalent to the binary string b
by invoking/calling the methods that you must have created */
        decimalString = _________________________________;
        octalyString = __________________________________;
        hexadecimalString = ____________________________________;
    }

    /**
     *Sets the decimal number to d, then the hexadecimal number, binary number and octal number
     *are set based on the decimal number.
     */
    public void setDecimalNumber(int d){
        decimalNumber = d;
/* 5. Assign the decimal string, octal string, and hexadecimal string that is equivalent to the binary string b
by invoking/calling the methods that you must have created */
        binaryString = _________________________________;
        octalyString = __________________________________;
        hexadecimalString = ____________________________________;
    }
    /**
     *Returns the hexadecimal digit cirresponding to a given number in the arnge 0 to 15
     **/
    public char hexDigit(byte digit){
        char r='0';
        switch (digit){
            case 0: r = '0'; break;
            case 1: r = '1'; break;
            case 2: r = '2'; break;
            case 3: r = '3'; break;
            case 4: r = '4'; break;
            case 5: r = '5'; break;
            case 6: r = '6'; break;
            case 7: r = '7'; break;
            case 8: r = '8'; break;
            case 9: r = '9'; break;
            case 10: r = 'A'; break;

            case 11: r = 'B'; break;
            case 12: r = 'C'; break;
            case 13: r = 'D'; break;
            case 14: r = 'E'; break;
            case 15: r = 'F'; break;
        }
        return r;
    }

    /**
     *Returns the decimal number corresponding to a given binary number
     **/
    public int binaryToDecimal(String b) throws Exception{
        int result=0;
/* 6. Complete the code by providing the needed statement/s. The code should be your own program and
not by reusing the methods that are provided in existing Java classes. */
        return result;
    }

    /**
     *Returns the decimal number corresponding to a given hexadecimal number
     **/
    public int hexadecimalToDecimal(String h){
        int result=0;
/* 7. Complete the code by providing the needed statement/s. The code should be your own program and
not by reusing the methods that are provided in existing Java classes. */

        return (result);
    }
    /**
     *Returns the decimal number corresponding to a given octal number
     **/
    public int octalToDecimal(String n){
        int result=0;
/* 8. Complete the code by providing the needed statement/s. The code should be your own program and not
by reusing the methods that are provided in existing Java classes. */

        return (result);
    }

    /**
     *Returns a string showing a whole number with its decimal, binary, ocatal and hexadecimal form.
     **/
    public String toString(){
        return ("Decimal Value = "+decimalNumber+"\nBinary Value = " + binaryString +"\nOctal Value = " +
                octalString + "\nHexadecimal Value = " + hexadecimalString);
    }
    /**
     *Returns true if this number is equivalent to another number.
     **/
    public boolean equals(EquivalentNumbers another){
        return (this.decimalNumber == another.getDecimalNumber());
    }
    private boolean isValidBinaryString(String s){
        boolean result = true;
        for (int index=0; index< s.length() && result; index++ ){
            if (s.charAt(index)!='0' && s.charAt(index)!='1')
                result = false;
        }
        return result;
    }
}