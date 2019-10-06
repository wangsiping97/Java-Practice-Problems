package rational;
import java.beans.DesignMode;
import java.lang.Math;

public class Rational {
    int numerator;
    int denominator;
    /**Construct func */
    Rational(int _numerator, int _demonimator) {
        numerator = _numerator;
        denominator = _demonimator;
        simplify();
    }
    /**add method */
    void add(Rational x) {
        numerator *= x.denominator;
        numerator += x.numerator * denominator;
        denominator *= x.denominator;
        simplify();
    }
    /**sub method */
    void sub(Rational x) {
        numerator *= x.denominator;
        numerator -= x.numerator * denominator;
        denominator *= x.denominator;
        simplify();
    }
    /**mul method */
    void mul(Rational x) {
        numerator *= x.numerator;
        denominator *= x.denominator;
        simplify();
    }
    /**div method */
    void div(Rational x) {
        denominator *= x.numerator;
        numerator *= x.denominator;
        simplify();
    }
    /**print */
    void printRational() {
        boolean isPositive = true;
        if ((double)numerator / denominator < 0) {
            isPositive = false;
        }
        int abs_numerator = Math.abs(numerator);
        int abs_denominator = Math.abs(denominator);
        if (abs_denominator == 1 || abs_numerator == 0) {
            System.out.println(numerator);
            return;
        }
        else {
            System.out.println(isPositive == true ? "" : "-" + abs_numerator + "/" + abs_denominator);
        }
    }
    void printReal() {
        System.out.println((double)numerator/denominator);
    }
    /**simplify method */
    void simplify() {
        if (numerator == 0) return;
        int abs_numerator = Math.abs(numerator);
        int abs_denominator = Math.abs(denominator);
        int min = Math.min(abs_numerator, abs_denominator);
        int max = Math.max(abs_numerator, abs_denominator);
        int i = max % min;
        while (i != 0) {
            max = min;
            min = i;
            i = max % min;
        }
        numerator /= min;
        denominator /= min;
    }
}