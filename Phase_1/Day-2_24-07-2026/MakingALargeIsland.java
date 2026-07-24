import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {
    private void dfs(int[][] grid, int r, int c, int k) {
        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length ||
            grid[r][c] != 1) {
            return;
        }

        grid[r][c] = k;

        dfs(grid, r + 1, c, k);
        dfs(grid, r - 1, c, k);
        dfs(grid, r, c + 1, k);
        dfs(grid, r, c - 1, k);
    }

    public int largestIsland(int[][] grid) {
        int k = 1, R = grid.length, C = grid[0].length;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    dfs(grid, r, c, ++k);
                }
            }
        }

        int[] cellCnt = new int[k+1];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int islId = grid[r][c];
                if (islId != 0) {
                    cellCnt[islId]++;
                }
            }
        }

        int maxSize = 0;
        for (int i : cellCnt) {
            maxSize = Math.max(maxSize, i);
        }

        int[] d = {0, 1, 0, -1, 0};
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> s = new HashSet<>();
                    for (int i = 0; i < 4; i++) {
                        int ar = r + d[i], ac = c + d[i+1];
                        if (ar >= 0 && ar < R && ac >= 0 && ac < C && grid[ar][ac] != 0) {
                            s.add(grid[ar][ac]);
                        }
                    }
                    int curSize = 1;
                    for (int iid : s) {
                        curSize += cellCnt[iid];
                    }
                    maxSize = Math.max(maxSize, curSize);
                }
            }
        }

        return maxSize;
    }
}
