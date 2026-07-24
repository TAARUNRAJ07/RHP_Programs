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

        while(q-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(arr[b] - arr[a-1]);
        }

        sc.close();
    }
}
