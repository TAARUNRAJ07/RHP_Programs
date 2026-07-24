import java.util.*;

public class StaticRangeSumQueries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int q = sc.nextInt();

        int[] arr = new int[N+1];

        for(int i = 1; i <= N; i++) {
            arr[i] = arr[i-1] +  sc.nextInt();
        }

        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int sum = arr[b] - arr[a-1];

            System.out.println(sum);

        }

        sc.close();
    }
}
