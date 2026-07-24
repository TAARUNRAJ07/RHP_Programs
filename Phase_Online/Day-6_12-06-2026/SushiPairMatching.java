import java.util.*;

public class SushiPairMatching {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int j = 0; j < m; j++) {
            b[j] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int count = 0;
        int n1 = n - 1;
        int m1 = m - 1;

        while (n1 >= 0 && m1 >= 0) {
            if (a[n1] * 2 >= b[m1]) {
                count++;
                n1--;
                m1--;
            } else {
                m1--;
            }
        }

        System.out.println(count);

        sc.close();
    }
}