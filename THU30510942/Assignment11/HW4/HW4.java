package HW4;

import java.io.BufferedReader;    
import java.io.FileReader;

class Frac {
    int numerator;
    int denominator;
    Frac() {
        numerator = 0;
        denominator = 1;
    }
    Frac (int num, int de) {
        numerator = num;
        denominator = de;
    }
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
    void add(Frac x) {
        numerator *= x.denominator;
        numerator += x.numerator * denominator;
        denominator *= x.denominator;
        simplify();
    }
    void div(int n) {
        denominator *= n;
        simplify();
    }
    String to_String() {
        return numerator + "/" + denominator;
    }
}

public class HW4 {
    public static void main (String[] args) throws Exception {
        String fileName = "a.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        String[] list = line.split(" ");
        reader.close();
        int count = 0;
        Frac sum = new Frac();
        for (String frac: list) {
            Frac temp = new Frac(Integer.parseInt(frac.split("/")[0]), Integer.parseInt(frac.split("/")[1]));
            sum.add(temp);
            count++;
        }
        System.out.println("Sum: " + sum.to_String());
        sum.div(count);
        System.out.println("Average: " + sum.to_String());
    }
}