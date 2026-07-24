import java.util.*;

public class TwoDigitStrings {
    
    public static int longestCommonSubsequence(int[] x, int[] y) {

        int m = x.length;
        int n = y.length;

        if (m == n && m == 0) {
            return 0;
        }

        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i-1] == y[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[m][n];
    }
    
    public static int modulo(String[] text) {
        String x = text[0];
        String y = text[1];
        
        int m = x.length();
        int n = y.length();
        
        int[] mx = new int[m];
        int[] my = new int[n];
        
        mx[0] = x.charAt(0) - '0';
        my[0] = y.charAt(0) - '0';
        
        for (int i = 1; i < m; i++) {
            mx[i] = (mx[i-1] + (x.charAt(i) - '0')) % 10;
        }
        
        for (int j = 1; j < n; j++) {
            my[j] = (my[j-1] + (y.charAt(j) - '0')) % 10;
        }
        
        if (mx[m-1] != my[n-1]) {
            return -1;
        }
        
        return longestCommonSubsequence(mx, my);
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        
        String[][] arr = new String[N+1][3];
        
        for(int i = 0; i < N; i++) {
            arr[i][0] = sc.nextLine();
            arr[i][1] = sc.nextLine();
        
            System.out.println(modulo(arr[i]));
        }
        
        sc.close();
    }
}