import java.util.Scanner;

public class HW1 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                System.out.print ("Please input integer1: ");
                int a = Integer.parseInt(in.next());
                System.out.print("Please input integer2: ");
                int b = Integer.parseInt(in.next());
                System.out.println("The sum is: " + (a + b));
                in.close();
                return;
            } catch(Exception e) {
                System.out.println ("Invalid input. Please try again. ");
            }
        }
    }
}