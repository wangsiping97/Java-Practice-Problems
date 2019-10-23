import java.util.Scanner; 

public class HW4 {
    static Scanner in = new Scanner(System.in);
    public static boolean equal(int[] list1, int[] list2) {
        if (list1.length != list2.length) return false;
        int n = list1.length;
        for (int i = 0; i < n; ++i) {
            if (list1[i] != list2[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main (String[] arguments) {
        System.out.print("Please input the length of list1: ");
        int n1 = in.nextInt();
        System.out.print("Please input the length of list2: ");
        int n2 = in.nextInt();
        int[] list1 = new int[n1];
        int[] list2 = new int[n2];
        System.out.println("Please input the content of list1: ");
        for (int i = 0; i < n1; ++i) {
            list1[i] = in.nextInt();
        }
        System.out.println("Please input the content of list2: ");
        for (int i = 0; i < n2; ++i) {
            list2[i] = in.nextInt();
        }
        if (equal(list1, list2)) {
            System.out.println("The two lists are equal. ");
        }
        else {
            System.out.println("The two lists are not equal. ");
        }
    }
}