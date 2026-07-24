import java.util.*;

public class NikitaAndBooks {
    public static String fun(int[] l) {
        int bal = 0;
        for (int i = 1; i < l.length; i++) {
            if (l[i] == i) {
                continue;
            }
            else if (l[i] > i) {
                bal += l[i] - i;
            }
            else {
                if (bal < (i - l[i])) {
                    return "NO";
                }
                bal -= (i - l[i]);
            }
        }
        return "YES";

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[][] arr = new int[N+1][];
        
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            int[] l = new int[n+1];
            
            for (int j = 1; j <= n; j++) {
                l[j] = sc.nextInt();
            }
            arr[i] = l;
        }
        
        for (int i = 0; i < N; i++) {
            System.out.println(fun(arr[i]));
        }
        sc.close();
    }
}