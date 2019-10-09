import java.util.Scanner;

public class HW2 {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] arguments) {
        System.out.print("Please input an integer: ");
        int test = in.nextInt();
        if (test != 0 && reverse(test) == 0) {
            System.out.println("Reverse overflow!");
            return;
        }
        if (isPalindrome(test) == true) {
            System.out.println("This number is a palindrome. ");
        }
        else {
            System.out.println("This number is NOT a palindrome. ");
        }
    }
    /** Return the reversal of an integer, i.e. reverse(567) returns 765 */
    public static int reverse(int number) {
        int reverse = 0;
        while (number >= 10 || number <= -10) {
            reverse += number % 10;
            number /= 10;
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && number > 7)) return 0;
            else if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && number > 8)) return 0;
            else {
                reverse *= 10;
            }
        }
        return reverse + number;
    }
    /** Return true if the number is palindrome (回文数) */
    public static boolean isPalindrome(int number) {
        return reverse(number) == number;
    }
}