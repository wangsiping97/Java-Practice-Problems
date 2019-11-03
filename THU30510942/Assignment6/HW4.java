import java.util.Scanner;
import java.io.FileInputStream;

public class HW4 {
    public static String[] findFirstGene(String str) {
        String[] ans = new String[2];
        ans[0] = "";
        ans[1] = str;
        int start = str.indexOf("ATG");
        if (start == -1) return ans;
        start += 3;
        int len = str.length();
        int i = start;
        for (; i + 2 < len; i += 3) {
            char[] temp = {str.charAt(i), str.charAt(i + 1), str.charAt(i + 2)};
            String substr = new String(temp);
            if (substr.equals("TAG") || substr.equals("TAA") || substr.equals("TGA")) {
                break;
            }
            ans[0] += substr;
        }
        if (i + 3 < len) {
            ans[1] = str.substring(i + 3);
        }
        else {
            ans[1] = "";
        }
        return ans;
    }
    public static void main (String[] arguments) throws Exception {
        FileInputStream fis = new FileInputStream("Data.txt");
        System.setIn(fis);
        Scanner in = new Scanner(System.in);
        String s = new String(in.nextLine());
        String[] ans = findFirstGene(s);
        if (ans[0] == "") {
            System.out.println("No genes.");
        }
        while (ans[0] != "") {
            System.out.println(ans[0]);
            s = ans[1];
            ans = findFirstGene(s);
        }
    }
}