import java.util.*;

public class MaximumValueRowWise {

    static long[] getFSmax(long[][] c, int row, int m) {
        long fmax = Long.MIN_VALUE;
        long smax = Long.MIN_VALUE;

        for (int j = 0; j < m; j++) {
            if (c[row][j] > fmax) {
                smax = fmax;
                fmax = c[row][j];
            } else if (c[row][j] > smax) {
                smax = c[row][j];
            }
        }

        return new long[]{fmax, smax};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        long[][] c = new long[n][m];

        for (int j = 0; j < m; j++) {
            c[0][j] = a[0][j];
        }

        for (int i = 1; i < n; i++) {
            long[] fmax = getFSmax(c, i - 1, m);

            for (int j = 0; j < m; j++) {
                c[i][j] = a[i][j]
                        + (c[i - 1][j] == fmax[0] ? fmax[1] : fmax[0]);
            }
        }

        long ans = Long.MIN_VALUE;

        for (int j = 0; j < m; j++) {
            ans = Math.max(ans, c[n - 1][j]);
        }

        System.out.println(ans);

        sc.close();
    }
}