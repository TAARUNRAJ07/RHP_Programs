import java.util.*;

public class DisjointSets {

    public static int find(int[] arr, int a) {
        if (arr[a] == a) {
            return a;
        }
        return find(arr, arr[a]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        int M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a] = b;
        }

        int[] leader = new int[N+1];

        for (int i = 1; i <= N; i++) {
            leader[i] = find(arr, i);
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(i + " -> " +leader[i]);
        }

        sc.close();

    }
}