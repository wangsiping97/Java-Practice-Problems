package complex;

public class Complex {
    double realPart;
    double imaginaryPart;
    /**Construct func */
    Complex(double _realPart, double _imaginaryPart) {
        realPart = _realPart;
        imaginaryPart = _imaginaryPart;
    }
    /**add method */
    void add(Complex x) {
        realPart += x.realPart;
        imaginaryPart += x.imaginaryPart;
    }
    /**sub method */
    void sub(Complex x) {
        realPart -= x.realPart;
        imaginaryPart -= x.imaginaryPart;
    }
    /**print method */
    String print() {
        String ans = "";
        if (imaginaryPart == 0) {
            ans += realPart;
            System.out.println(ans);
        }
        else {
            ans  = realPart + "+" + imaginaryPart + "i";
            System.out.println(ans);
        }
        return ans;
    }
}