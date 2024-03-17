package CombinedCodes;

    /**
     * The Fraction class represents a fraction with numerator and denominator attributes.
     *
     * This class contains constructors, setter and getter methods, and methods to
     * perform basic operations on fractions, such as arithmetic operations and
     * reducing a fraction to its simplest form. This class also includes methods
     * to represent a fraction as a String and as a double.
     */
    public class Fraction {
        private int numerator;
        private int denominator;

        /**
         * Constructs a fraction with default values of 0 as its numerator and 1 as its denominator.
         */
        public Fraction() {
            numerator = 0;
            denominator = 1;
        }

        /**
         * Constructs a fraction with the given numerator and denominator.
         */
        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        /**
         * Sets the numerator of the fraction.
         */
        public void setNumerator(int num) {
            numerator = num;
        }

        /**
         * Returns the numerator of the fraction.
         */
        public int getNumerator() {
            return numerator;
        }

        /**
         * Sets the denominator of the fraction.
         */
        public void setDenominator(int den) {
            denominator = den;
        }

        /**
         * Returns the denominator of the fraction.
         */
        public int getDenominator() {
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

        public Fraction multiplyBy(Fraction fraction2) {
            int productNum = numerator * fraction2.getNumerator();
            int productDen = denominator * fraction2.getDenominator();

            return new Fraction(productNum, productDen);
        }

        public Fraction divideBy(Fraction fraction2) {
            if (fraction2.getNumerator() == 0 || fraction2.getDenominator() == 0) {
                return new Fraction(1, 0);
            }

            int quotientNum = numerator * fraction2.getDenominator();
            int quotientDen = denominator * fraction2.getNumerator();

            return new Fraction(quotientNum, quotientDen);
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

        public Fraction reduce() {
            int gCD = computeGCD();

            try {
                int num = numerator / gCD;
                int den = denominator / gCD;

                return new Fraction(num, den);
            } catch (Exception exception) {
                return new Fraction(numerator, denominator);
            }
        }

        private int computeGCD() {
            int x = numerator;
            int y = denominator;

        /*
        The larger number must be `x`. As such, if `y` is larger than `x`,
        then they swap values so the value of `x` is greater than `y`.
         */
            if (y > x) {
                int temp = x;
                x = y;
                y = temp;
            }

        /*
        This loop repeatedly takes the remainder of `x` divided by `y`,
        assigns `y` to `x`, and assigns the remainder to `y`, until the
        remainder (assigned to `y`) is zero. After the loop terminates,
        the last non-zero remainder (assigned to `x`) is the GCD.
         */
            while (y != 0) {
                int remainder = x % y;
                x = y;
                y = remainder;
            }
            int gCD = x;

            return gCD;
        }
            public MixedFraction toMixedFraction(){
        int numerator = this.getNumerator();
        int denominator = this.getDenominator();
        int wholeNumber = numerator/denominator;
        numerator = numerator - (wholeNumber * denominator);
        return new MixedFraction (wholeNumber, numerator, denominator);
    }

        public double toDouble() {
            return (double) numerator/denominator;
        }

        public String toString() {
            if (denominator == 0) {
                return "Undefined";
            } else if (denominator < 0) {
                int num = numerator * -1;
                int den = denominator * -1;
                return num + "/" + den;
            } else {
                return numerator + "/" + denominator;
            }
        }
}
