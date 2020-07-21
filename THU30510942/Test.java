import java.lang.Math;
import java.math.BigInteger;

public class Test {
    static int M = 4;
    static int N = 4;
    static BigInteger count = new BigInteger("0");
    static int A = M * N / 2;
    static int B = A;
    static int[][] a = new int[M][N];
    static int get(int m, int n) {
        if (m < 0 || m >= M) return -1;
        if (n < 0 || n >= N) return -1;
        else return a[m][n];
    }
    static boolean check(int i, int j) {
        int status = get(i, j);
        if (status == -1) return true;
        if (get(i - 1, j) == 3 - status || get(i+1, j) == 3 - status || get(i, j-1) == 3 - status || get(i, j+1) == 3 - status) return true;
        return false;
    }
    static void dfs(int x, int y) {
        if (x == M) {
            for (int i = 0; i < M; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (check(i, j) == false) return;
                }
            }
            count = count.add(new BigInteger("1"));
            return;
        }
        a[x][y] = 1;
        A--;
        if (A >= 0) {
            if (y == N - 1) dfs(x + 1, 0);
            else dfs(x, y +1);
        }
        A++;
        a[x][y] = 2;
        B--;
        if (B >= 0) {
            if (y == N - 1) dfs(x + 1, 0);
            else dfs(x, y +1);
        }
        B++;
    }
    public static void main (String[] args) {
        dfs(0, 0);
        System.out.println(count);
    }
}