package CombinedCodes;

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

    /**
     * This method converts the {@code MixedFraction} to {@code Fraction}.
     *
     * <p>
     * A mixed fraction is represented as:
     * <ul>
     *     {@code wholeNumber (numerator/denominator)}
     * </ul>
     *
     * This method multiplies the whole number by the denominator then
     * adds the numerator to the product. The result is then assigned as
     * the new numerator while the denominator remains the same.
     *
     * <ul>
     *     The mixed fraction becomes:
     *     <ul>
     *         {@code [(wholeNumber * denominator) + numerator]/denominator}
     *     </ul>
     * </ul>
     * </p>
     *
     * @return the converted {@code MixedFraction} as a new {@code Fraction}.
     */
    public Fraction toFraction(){
        int newNumerator = (this.wholeNumber * this.getDenominator()) + this.getNumerator();
        // Returns a new fraction
        return new Fraction(newNumerator, this.getDenominator());
    }

    /**
     * Returns a {@code String} representation of the mixed fraction as
     * "{@code wholeNumber numerator/denominator}".
     *
     * <p>
     * If the whole number is 0;
     * <ul>
     *     this method returns the mixed fraction without its whole number.
     *     For example, {@code 0 3/5} will be returned as {@code 3/5}.
     * </ul>
     *
     * If the denominator is equal to 1;
     * <ul>
     *     this method returns an integer equal to {@code wholeNumber + numerator}.
     *     For example, {@code 2 2/1} will be returned as {@code 4} (2 + 2).
     * </ul>
     *
     * If the denominator is negative;
     * <ul>
     *     both numerator and denominator will be multiplied to -1 so that a mixed
     *     fraction with a negative denominator will not be displayed as
     *     "{@code wholeNumber numerator/-denominator}," but "{@code wholeNumber -numerator/denominator}."
     *     For example, {@code 2 18/-8} will be returned as {@code 2 -18/8}.
     * </ul>
     */
    public String toString() {
        if (wholeNumber == 0) {
            return getNumerator() + "/" + getDenominator();
        } else if (getDenominator() == 1) {
            return String.valueOf(wholeNumber + getNumerator());
        } else if (getDenominator() < 0) {
            int num = getNumerator()* -1;
            int den = getDenominator()* -1;
            return wholeNumber + " " + num + "/" + den;
        } else {
            return wholeNumber + " " + getNumerator() + "/" + getDenominator();
        }
    }

    /**
     * Adds another mixed fraction to this mixed fraction.
     *
     * @param mixedFrac2 the other mixed fraction to be added to this mixed fraction
     * @return the sum as a new mixed fraction.
     */
    public MixedFraction add(MixedFraction mixedFrac2) {
        int sumWhole = wholeNumber + mixedFrac2.getWhole();
        Fraction fraction1 = this.getFractionPart();
        Fraction fraction2 = mixedFrac2.getFractionPart();

        Fraction sumFrac = fraction1.add(fraction2);

        return new MixedFraction(sumWhole, sumFrac.reduce());
    }

    /**
     * Subtracts another mixed fraction from this mixed fraction.
     *
     * @param mixedFrac2 the other mixed fraction to be subtracted from this mixed fraction
     * @return the difference as a new mixed fraction
     */
    public MixedFraction subtract(MixedFraction mixedFrac2) {
        int diffWhole = wholeNumber - mixedFrac2.getWhole();
        Fraction fraction1 = this.getFractionPart();
        Fraction fraction2 = mixedFrac2.getFractionPart();

        Fraction diffFrac = fraction1.subtract(fraction2);

        return new MixedFraction(diffWhole, diffFrac.reduce());
    }

    /**
     * Multiplies this mixed fraction by another mixed fraction.
     *
     * @param mixedFrac2 the other mixed fraction to multiply this
     *                   mixed fraction by
     * @return the product as a new mixed fraction
     */
    public MixedFraction multiplyBy(MixedFraction mixedFrac2) {
        // Multiply the whole numbers
        int resultWhole = wholeNumber * mixedFrac2.getWhole();

        // Multiply the fractions
        Fraction fraction1 = this.getFractionPart();
        Fraction fraction2 = mixedFrac2.getFractionPart();
        Fraction resultFraction = fraction1.multiplyBy(fraction2);

        return new MixedFraction(resultWhole, resultFraction.reduce());
    }
    
    /*Divide this whole number of the mixed fraction to another
    * whole number of the mixed fraction then invert the fraction 2
    * and multiply the mixed fractions
    * then returns the quotient as a new mixed number
    * */
    public MixedFraction divideBy(MixedFraction mixedFrac2) {
        // Divide the whole numbers
        int resultWhole = wholeNumber / mixedFrac2.getWhole();

        // Invert and multiply the fractions
        Fraction fraction1 = this.getFractionPart();
        Fraction fraction2 = new Fraction(mixedFrac2.getDenominator(), mixedFrac2.getNumerator());
        Fraction resultFraction = fraction1.divideBy(fraction2);

        return new MixedFraction(resultWhole, resultFraction.reduce());
    }
}
