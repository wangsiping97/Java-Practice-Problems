package numhashmap;

import java.util.HashMap;

public class NumHashMap {
    HashMap<Character, Character> directory = new HashMap<Character, Character>();
    Character[] keys = new Character[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u','v', 'w', 'x', 'y', 'z'};
    Character[] values = new Character[] {'v', 'e', 'k', 'n', 'o', 'h', 'z', 'f', 'a', 'l', 'j', 'x', 'd', 'm', 'y', 'g', 'b', 'r', 'c', 's', 'w', 'q', 'u', 'p', 't', 'i'};
    NumHashMap() {
        for (int i = 0; i < 26; ++i) {
            directory.put(keys[i], values[i]);
            directory.put(Character.toUpperCase(keys[i]), Character.toUpperCase(values[i]));
        }
    }
    public String decode(String str) {
        String res = "";
        int l = str.length();
        for (int i = 0; i < l; ++i) {
            if ((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')) {
                for (Character key: directory.keySet()) {
                    if (directory.get(key).equals(str.charAt(i))) {
                        res += Character.toString(key);
                    }
                }
            }
            else res += str.charAt(i);
        }
        return res;
    }
}