import java.util.Scanner;

public class LongestIncreasingPathInMatrix {

    static final int[][] diff = {
        {0, -1}, {0, 1}, {-1, 0}, {1, 0}
    };

    private static int dfs(int[][] matrix, int[][] dp, int R, int C, int row, int col) {

        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int maxLen = 0;

        for (int i = 0; i < 4; i++) {
            int nr = row + diff[i][0];
            int nc = col + diff[i][1];

            if (nr >= 0 && nr < R &&
                nc >= 0 && nc < C &&
                matrix[nr][nc] > matrix[row][col]) {

                maxLen = Math.max(maxLen,
                                  dfs(matrix, dp, R, C, nr, nc));
            }
        }

        dp[row][col] = maxLen + 1;
        return dp[row][col];
    }

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int R = matrix.length;
        int C = matrix[0].length;

        int[][] dp = new int[R][C];
        int ans = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans = Math.max(ans,
                               dfs(matrix, dp, R, C, i, j));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();

        int[][] matrix = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(longestIncreasingPath(matrix));

        sc.close();
    }
}