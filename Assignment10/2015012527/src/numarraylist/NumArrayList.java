package numarraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class NumArrayList {
    ArrayList<Integer> list = new ArrayList<Integer>();
    NumArrayList(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            Integer obj = new Integer(a[i]);
            list.add(obj);
        }
    }
    public ArrayList<Integer> work() {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (Integer integ: list) {
            if ((int)integ >= 5000) {
                res.add(integ);
            }
        }
        return res;
    }
}