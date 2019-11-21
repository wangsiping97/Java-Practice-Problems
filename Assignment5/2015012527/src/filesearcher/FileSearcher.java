package filesearcher;

import java.io.BufferedReader;    
import java.io.FileReader;
import java.util.ArrayList;

public class FileSearcher {
    ArrayList<String> wordList = new ArrayList<String>();
    FileSearcher (String fileName) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;
        while ((line = reader.readLine()) != null) {
            int i = 0, j = 0;
            while (j < line.length()) {
                while (i < line.length() && !Character.isLetter(line.charAt(i))) {
                    i++;
                }
                j = i + 1;
                while (j < line.length() && Character.isLetter(line.charAt(j))) {
                    j++;
                }
                if (j <= line.length()) {
                    String word = line.substring(i, j);
                    wordList.add(word);
                }
                i = j + 1;
            }
        }
    }
    public int search (String w) {
        int ans = 0;
        for (int i = 0; i < wordList.size(); ++i) {
            if (w.equalsIgnoreCase(wordList.get(i))) {
                ans++;
            }
        }
        return ans;
    }
}