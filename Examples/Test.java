import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        TreeSet<String> words = new TreeSet<String>();
        words.add("Bats");
        words.add("Ants");
        words.add("Crabs");
        words.add("Ants");
        System.out.println(words.size());
        for (String word : words) {
        System.out.println(word);
        }

    }
}
