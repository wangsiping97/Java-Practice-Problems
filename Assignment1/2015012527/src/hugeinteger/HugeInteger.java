package hugeinteger;

public class HugeInteger {
    int[] arr = new int[41];
    String str;
    /**construct func */
    HugeInteger(String _str) {
        input(_str);
    }
    /**input method */
    void input(String _str) {
        str = _str;
        int n = _str.length();
        if (_str.charAt(0) == '-') {
            arr[40] = 1;
            int i;
            for (i = 1; i < n; ++i) {
                arr[i - 1] = 9 - (_str.charAt(n - i) - '0'); // 反码
            }
            for (; i < 41; ++i) {
                arr[i - 1] = 9;
            }
            arr[0] += 1; // 补码
            carry();
        }
        else {
            arr[40] = 0;
            int i;
            for (i = 0; i < n; ++i) {
                arr[i] = _str.charAt(n - i - 1) - '0';
            }
            for (; i < 40; ++i) {
                arr[i] = 0;
            }
        }
    }
    /**output method */
    void output() {
        System.out.println(str);
    }
    /**add method */
    void add(HugeInteger x) {
        for (int i = 0; i < 41; ++i){
            arr[i] += x.arr[i];
        }
        carry();
        updateStr();
    }
    /**sub method */
    void sub(HugeInteger x) {
        String _str = x.str;
        if (x.str.charAt(0) == '-') {
            _str = _str.substring(1, _str.length());
        }
        else {
            _str = '-' + _str;
        }
        HugeInteger _x = new HugeInteger(_str);
        add(_x);
    }
    /**comparison funcs */
    boolean isEqualTo(HugeInteger x) {
        for (int i = 0; i < 41; ++i) {
            if (arr[i] != x.arr[i]) {
                return false;
            }
        }
        return true;
    }

    boolean isNotEqualTo(HugeInteger x) {
        for (int i = 0; i < 41; ++i) {
            if (arr[i] != x.arr[i]) {
                return true;
            }
        }
        return false;
    }

    boolean isGreaterThan(HugeInteger x) {
        HugeInteger _this = new HugeInteger(str);
        _this.sub(x);
        if (_this.arr[40] == 1) return false;
        if (isEqualTo(x)) return false;
        return true;
    }

    boolean isLessThan(HugeInteger x) {
        HugeInteger _this = new HugeInteger(str);
        _this.sub(x);
        if (_this.arr[40] == 1) return true;
        return false;
    }

    boolean isGreaterThanOrEqualTo(HugeInteger x) {
        HugeInteger _this = new HugeInteger(str);
        _this.sub(x);
        if (_this.arr[40] == 1) return false;
        return true;
    }

    boolean isLessThanOrEqualTo(HugeInteger x) {
        HugeInteger _this = new HugeInteger(str);
        _this.sub(x);
        if (_this.arr[40] == 1) return true;
        if (isEqualTo(x)) return true;
        return false;
    }
    /**carry */
    void carry() {
        for (int i = 0; i < 40; i++) {
            if (arr[i] >= 10) {
                arr[i] -= 10;
                arr[i + 1] += 1;
            }
            if (arr[i] < 0) {
                arr[i] += 10;
                arr[i + 1] -= 1;
            }
        }
        if (arr[40] >= 2) {
            arr[40] -= 2;
        }
    }
    /**update str */
    void updateStr() {
        str = "";
        if (arr[40] == 0) {
            int i = 39;
            while (i >= 0 && arr[i] == 0) {
                i--;
            }
            if (i == -1) {
                str += '0';
                return;
            }
            for (; i >= 0; --i) {
                str += arr[i];
            }
        }
        else {
            str += '-';
            arr[0] -= 1;
            carry();
            for (int i = 0; i < 40; i++) {
                arr[i] = 9 - arr[i];
            }
            int i = 39;
            while (i >= 0 && arr[i] == 0) {
                i--;
            }
            for (; i >= 0; --i){
                str += arr[i];
            }
        }
    }
}