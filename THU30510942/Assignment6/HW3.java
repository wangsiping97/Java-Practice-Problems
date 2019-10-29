import java.util.Scanner;

public class HW3 {
    public static String sort(String s) {
        int n = s.length();
        char[] arrChar = new char[n];
        for (int i = 0; i < n; ++i) {
            arrChar[i] = s.charAt(i);
        }
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - 1 - i; ++j) { 
                if (arrChar[j] > arrChar[j + 1]) { 
                    char temp = arrChar[j];
                    arrChar[j] = arrChar[j + 1];
                    arrChar[j + 1] = temp;
                }
            }
        }
        String ans = "";
        for (char c: arrChar) {
            ans += c;
        }
        return ans;
    }
    public static void main (String[] arguments) {
        Scanner in = new Scanner (System.in);
        System.out.print("Please input a string: ");
        String s = in.next();
        System.out.println(sort(s));
    }
}