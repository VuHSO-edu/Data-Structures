package Hw3_22000132_NguyenDuyVu;

public class Fraction {
    private float numerator;
    private float denominator;

    public Fraction(float numerator, float denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }


    public Fraction add(Fraction c) {
        float newNumerator = this.numerator * c.denominator + c.numerator * this.denominator;
        float newDenominator = this.denominator * c.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction minus(Fraction c) {
        float newNumerator = this.numerator * c.denominator - c.numerator * this.denominator;
        float newDenominator = this.denominator * c.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multi(Fraction c) {
        float newNumerator = this.numerator * c.numerator;
        float newDenominator = this.denominator * c.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divi(Fraction c) {
        float newNumerator = this.numerator * c.denominator;
        float newDenominator = this.denominator * c.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction normalize(Fraction c){
        float gcd = gcd(c.numerator, c.denominator);
        return new Fraction(c.numerator/gcd, c.denominator/gcd);
    }

    private float gcd(float numerator, float denominator) {
        if (denominator == 0) {
            return numerator;
        }
        return gcd(denominator, numerator % denominator);
    }

    public float getNumerator() {
        return numerator;
    }

    public float getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}
