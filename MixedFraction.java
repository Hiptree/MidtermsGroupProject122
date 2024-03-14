package Fractionaaa;

public class MixedFraction extends Fraction {
    private int wholeNumber; //instance variable for the whole number
    
    /**
     * This constructor creates a MixedFraction object with a whole number and a Fraction object
     * for example, if you want to make a mixed fraction with a whole number and a fraction lets
     * say you have wholenumber = 3 nad   the fraction =1/2 this constructor will make
     * the mixed fraction 3 1/2
     */
    public MixedFraction(int whole, Fraction fraction){
        super(fraction.getNumerator(), fraction.getDenominator());//initialize the Fraction part of the MixedFraction object
        this.wholeNumber=whole;
    }
    //
    public MixedFraction(int whole, int numerator, int denominator){
        super(numerator, denominator);//initialize the Fraction part of the MixedFraction object
        this.wholeNumber = whole;
    }

    /**
     * This constructor creates a MixedFraction object with just a fraction object
     * Example: if you have the fraction 2/4, this constructor will make the mixed fraction
     * 0 1/2 which is just 1/2
     */
    public MixedFraction(Fraction fraction){
        super(fraction.getNumerator(), fraction.getDenominator());//initialize the Fraction part of the MixedFraction object
        this.wholeNumber = 0;
    }

    // Setter for wholeNumber
    public void setWholeNumber(int whole){
        this.wholeNumber = whole;
    }

    // Getter for wholeNumber
    public int getWhole(){
        return this.wholeNumber;
    }

    // Setter for Fraction Part
    public void setFractionPart(Fraction fraction){
        this.setNumerator(fraction.getNumerator());
        this.setDenominator(fraction.getDenominator());
    }

    // Getter for Fraction Part
    public Fraction getFractionPart(){
        return new Fraction (this.getNumerator(), this.getDenominator());
    }

    /** This method converts the MixedFraction to Fraction
     * mixed fraction represented as
     *              numerator
     *  wholeNumber ---------
     *              denominator
     * The method multiplies the whole number by the denominator
     * then adds the numerator to multiplied numbers
     * the denominator remains the same
     *
     *the mixed fraction becomes
     * (wholeNumber * denominator) + numerator
     * --------------------------------------
     *              deenominator
     */

    public Fraction toFraction(){
        int newNumerator = this.wholeNumber * this.getDenominator() + this.getNumerator();
        // Returns a new fraction
        return new Fraction(newNumerator, this.getDenominator());
    }

    /** this method checks if the denominator is 0 if zero, returns undefined.
     * else if the denominator is zero for example 18/-9 the denominator
     * and the numerator will be multiplied by -1
     * then it will return the numerator and the denominator as -numerator/denominator
     * instead of numerator/-denominator
     * if the denominator is not negative then it will return numerator/denominator
    */

    public String toString() {

        if (getDenominator() == 0) {
            return "Undefined";
        } else if (getDenominator() < 0) {
            int num = getNumerator()* -1;
            int den = getDenominator()* -1;
            return wholeNumber + " " + num + "/" + den;
        } else {
            return wholeNumber + " " + getNumerator() + "/" + getDenominator();
        }
    }


}
