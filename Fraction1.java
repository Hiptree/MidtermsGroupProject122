package prog2.prelim;

public class Fraction {
    /** initialize instance variables*/
    private int numerator;
    private int denominator;

    /**create the constructor*/
    public Fraction(){
        numerator= 0;
        denominator = 1;
    }
    /**contructor with parameters*/
    public Fraction(int wholeNumberVal){
        this.numerator = wholeNumberVal;
        this.denominator = 1;
    }
    public Fraction(int num , int den){
        numerator=num;
        denominator=den;
    }
    /**create setters and getters for each instance variables*/
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    public void setDenominator(int denominator){
        this.denominator=denominator;
    }
    public int getNumerator() {
        return numerator;
    }
    public int getDenominator(){
        return denominator;
    }
    public Fraction add(Fraction another){
        Fraction sum = new Fraction(); //create an object of fraction that will hold the value of added fractions

        //fractions with 0 as denominator does not exist and is therefore invalid
        if (this.denominator ==0 || another.denominator==0){
            throw new IllegalArgumentException("Denominator cannot be 0");
        }

        //this will be executed if the fractions are similar
        if(this.denominator == another.denominator){
            sum.numerator = this.numerator+ another.numerator;
            sum.denominator = this.denominator;
        }else {

            //if the fractions are dissimilar, this codes will be executed
            //compute for LCD of two fractions to start converting
            int lcd = computeLCD(this.denominator, another.denominator);

            //now that we have the LCD, the next step is to convert each fraction to make them similar
            //but since we are making a new fraction here, we must create an object of new fraction
            Fraction convertedFraction = new Fraction(); //object of fraction for the first fraction
            Fraction convertedAnother = new Fraction(); //object of fraction for the second fraction
            convertedFraction = makeSimilar(lcd);   //call the method to make them similar and pass the value of their lcd
            convertedAnother = another.makeSimilar(lcd);

            // integrate the values to the object sum
            sum.numerator = convertedFraction.numerator +convertedAnother.numerator;
            sum.denominator = lcd;
        }
        return sum;
    }
    public Fraction subtract(Fraction another){
        if (this.denominator == another.denominator) {
            // If the denominators are the same, subtract the numerators directly
            int newNumerator = this.numerator - another.numerator;
            return new Fraction(newNumerator, this.denominator);
        } else {
            // Different denominators
            // Step 1: Find the LCD
            int lcd = computeLCD(this.denominator, another.denominator);
            // Step 2: Multiply both fractions with the number that results in the LCD
            int newNumerator1 = this.numerator * (lcd / this.denominator);
            int newNumerator2 = another.numerator * (lcd / another.denominator);
            // Step 3: Subtract the numerators since the denominators are now the same
            int newNumerator = newNumerator1 - newNumerator2;
            int newDenominator = lcd;
            // Step 4: Simplify the result
            return new Fraction(newNumerator, newDenominator);
        }
    }//end of method
    public Fraction multiplyBy(Fraction another){
        // Multiply the numerators and denominators separately
        int newNumerator = this.numerator * another.numerator;
        int newDenominator = this.denominator * another.denominator;

        // Create a new Fraction object with the multiplied values
        Fraction result = new Fraction(newNumerator, newDenominator);


        // Update the current object with the simplified result
        result.numerator = newNumerator;
        result.denominator = newDenominator;
        return result;
    }
    public Fraction divideBy(Fraction another){
        //in dividing fraction, we must get the reciprocal of the 2nd fraction then proceed to multiplication
        int reciprocalDenominator = another.numerator;
        int reciprocalNumerator = another.denominator;

        Fraction reciprocal = new Fraction(reciprocalNumerator, reciprocalDenominator);

        int newNumerator = reciprocal.numerator * this.numerator;
        int newDenominator= reciprocal.denominator * this.denominator;

        return new Fraction ( newNumerator, newDenominator);
    }
    /**this method will compute the least common denominator to make dissimilar fractions similar*/
    private int computeLCD(int denominator1 , int denominator2){
        /*set the initial value of common factor to denominator 1
         so that when the addition assignment operator will be helpful*/
        int commonFactor = denominator1;

        /*loop until the remainder is not = 0.
         when 0, this means that the final value is now the common factor or the LCD*/
        while ((denominator1%denominator2)!= 0)
            denominator1 += commonFactor;

        /*addition assignment operator, it works by adding
        the commonFactor to denominator1 and making it the value of denominator 1*/
        return denominator1;
    }
    /**This method will help convert fractions so that two fractions will be similar
     * with the help of computed LCD from the previous method
     */
    private Fraction makeSimilar (int LCD){ //in converting fractions into similar, we need the LCD
        Fraction result = new Fraction(); //create a new object of fraction

        /*in converting similar fractions, we need to divide the LCD to the denominator
        and the resulting factor will be multiplied to the numerator so that it will still be equal*/
        int multiplier = LCD/ denominator;
        result.numerator = numerator*multiplier; //multiply the factor to the numerator
        result.denominator = LCD; //the denominator will be the LCD
        return result;
    }
    /**  method to create GCD
     GCD is used to convert fractions into its simplest form
     example: 2/4 = 1/2
     we need the denominator of the 1st fraction and 2nd fraction, hence the parameters*/
    private int computeGCD(int denominator1, int denominator2){
        /*in this code, we will utilize the euclid's algorithm to find gcd
        by doing this, we need the remainders of denominators. so:*/
        int remainder;

        /*we will initialize the value of remainder to the second denominator
        because while the remainder is not yet equal to 0, the denominator1 will be the denominator2
        and denominator2 will be the remainder. so:*/
        while (denominator2!=0) { //when denominator is not yet equal to 0, it means that it is not a common factor of two numbers
            remainder = denominator2;
            denominator2 = denominator1%denominator2; //this is to get the remainder of the two denominators. the variable name denominator2 is ok since it will be also the value of remainder
            denominator1 = remainder;
        }
        return denominator1; //we have to return the last value when the remainder became 0, hence denominator1
    }
    /**this method will help convert fractions into its lowest term with the help of
     *computed LCD from the previous method
     */
    public Fraction simplify(){
        Fraction result = new Fraction(); //create an object of fraction
        int gcd = 0; //initialize the value of gcd to 0
        /*now, there are what you call as improper or proper fractions.
         * improper fractions have their numerator greater than denominator
         * proper fractions have their numerator less than the denominator
         * distinguishing what kind of fraction it was is significant in computing GCD because the gcd may differ */
        if (numerator > denominator){   // for improper fractions
            gcd = computeGCD(numerator, denominator);
        }else if (numerator < denominator){     // for proper fractions
            gcd = computeGCD(denominator, numerator);
        }else {
            gcd = numerator; //when they are equal, there is no need to change, just equate the numerator with the LCD
        }

        result.numerator = numerator/gcd; //divide the gcd to the numerator to simplify
        result.denominator = denominator/gcd; //divide the gcd to denominator to simplify
        return result;
    }
    //method used to convert fractions into its whole number equivalent
    public double convertWholeNumber (){
        return ((double) numerator / (double) denominator); // simply divide the numerator to denominator
        // we have to type cast each variable into double because the data type
        //of these two instance variables are initially declared as int
    }
    public String toString() {
        return numerator + "/" + denominator;
    }
}
