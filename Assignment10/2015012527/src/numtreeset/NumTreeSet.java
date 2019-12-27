package numtreeset;

import java.util.TreeSet;

public class NumTreeSet {
    TreeSet<Integer> set = new TreeSet<Integer>();
    NumTreeSet(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            set.add(a[i]);
        }
    }
    public int work() {
        return set.size();
    }
}