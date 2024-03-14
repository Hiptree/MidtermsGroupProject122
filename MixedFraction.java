package Fractionaaa;

public class MixedFraction extends Fraction {
    private int wholeNumber; //instance variable for the whole number

    public MixedFraction(int wholeNumber, int numerator, int denominator){
        super(numerator, denominator);
        this.wholeNumber = wholeNumber;
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
