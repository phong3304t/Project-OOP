// abcdef
public class Solution {
    private int numerator;
    private int denominator;

    /**
     * Fraction class constructor.
     *
     * @param numerator   set numerator
     * @param denominator set denominator
     */
    public Solution(int numerator, int denominator) {
        if (denominator != 0) {
            setNumerator(numerator);
            setDenominator(denominator);
        } else {
            setNumerator(numerator);
            setDenominator(1);
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    /**
     * Denominator setter, denominator = 0 not allowed.
     *
     * @param denominator denominator to set to
     */
    public void setDenominator(int denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
        }
    }

    /**
     * toi gian phan so.
     *
     * @return
     */
    public Solution reduce() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        if (gcd == 0) {
            return this;
        }
        numerator /= gcd;
        denominator /= gcd;

        return this;
    }

    /**
     * tim ucln.
     *
     * @param a abc
     * @param b abc
     * @return
     */
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    /**
     * Add.
     *
     * @param fraction another fraction
     * @return another Fraction instance
     */
    public Solution add(Solution fraction) {
        if (fraction.getDenominator() != 0) {
            this.numerator = (this.numerator * fraction.getDenominator())
                    + (fraction.getNumerator() * this.denominator);
            this.denominator = this.denominator * fraction.getDenominator();
        }
        return this.reduce();
    }

    /**
     * Subtract.
     *
     * @param fraction another fraction
     * @return another Fraction instance
     */
    public Solution subtract(Solution fraction) {
        if (fraction.getDenominator() != 0) {
            this.numerator = (this.numerator * fraction.getDenominator())
                    - (fraction.getNumerator() * this.denominator);
            this.denominator = this.denominator * fraction.getDenominator();
        }
        return this.reduce();
    }

    /**
     * Multiply fraction.
     *
     * @param other another fraction
     * @return another Fraction instance
     */
    public Solution multiply(Solution other) {
        if (other.getDenominator() != 0) {
            this.numerator = this.numerator * other.getNumerator();
            this.denominator = this.denominator * other.getDenominator();
        }
        return this.reduce();
    }

    /**
     * Divide fraction.
     *
     * @param fraction another fraction
     * @return another Fraction instance
     */
    public Solution divide(Solution fraction) {
        if (fraction.getDenominator() != 0) {
            this.numerator = this.numerator * fraction.getDenominator();
            this.denominator = this.denominator * fraction.getNumerator();
        }
        return this.reduce();
    }

    /**
     * Compare fraction, return true if same, false if not.
     *
     * @param obj another object that's possibly a fraction
     */
    public boolean equals(Object obj) {
        if (obj instanceof Solution) {
            Solution other = (Solution) obj;

            other = other.reduce();
            return other.getNumerator() == this.reduce().getNumerator()
                    && other.getDenominator() == this.reduce().getDenominator();
        }
        return false;
    }
}
