import java.util.*;

public class IHateSigmaProblems {
    public static long calculateDistinctSum(long[] arr, int N) {
        long sum = 0, lSum = 0;
        HashMap<Long, Integer> Prev = new HashMap<>();
        for(int i = 1; i <= N; i++) {

            lSum = lSum - Prev.getOrDefault(arr[N-i], 0) + i;
            Prev.put(arr[N-i], i);
            sum += lSum;
        }        
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(calculateDistinctSum(arr, N));

        sc.close();
    }
}