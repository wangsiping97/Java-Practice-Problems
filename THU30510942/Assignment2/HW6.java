import java.util.Scanner;
import java.lang.Math;

public class HW6 {
    static Scanner in = new Scanner(System.in);
    public static int HumanVSComputer (int _human, int _computer) {
        if (_human > 2 || _human < 0) return 10;
        if (_human == 0 && _computer == 2) return 1;
        if (_human == 2 && _computer == 0) return -1;
        else {
            if (_human > _computer) return 1;
            if (_human == _computer) return 0;
            else return -1;
        }
    }
    public static void main (String[] argument) {
        System.out.println("0 - Scissor, 1 - Rock, 2 - Paper");
        int score = 100;
        while (true) {
            int computer = (int)(Math.random() * 3);
            System.out.print("Please input an integer between (0, 1, 2): ");
            int human = Integer.parseInt(in.next());
            System.out.print("Computer: ");
            System.out.println(computer);
            if (score != 0 && score == HumanVSComputer(human, computer)) break;
            score = HumanVSComputer(human, computer);
        }
        switch(score) {
            case 1: 
                System.out.println("Human wins!");
                break;
            case -1: 
                System.out.println("Computer wins!");
                break;
            default: 
                System.out.println("Invalid input!");
        }
    }
}