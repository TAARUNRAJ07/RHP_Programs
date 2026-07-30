import java.util.*;


public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int R = grid.length, C = grid[0].length, oranges = 0, ans = 0;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] != 0) {
                    oranges++;
                }
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j, 0});
                    grid[i][j] = 0;
                }
            }
        }

        int d[] = {0, 1, 0, -1, 0};
        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0], col = cell[1], dy = cell[2];
            ans = dy;
            oranges--;
            for (int i = 0; i < 4; i++) {
                int ar = row + d[i], ac = col + d[i+1];
                if (ar >= 0 && ar < R && ac >= 0 && ac < C && grid[ar][ac] == 1) {
                    q.add(new int[]{ar, ac, dy+1});
                    grid[ar][ac] = 0;
                }
            }
        }
        return oranges == 0 ? ans : -1;
    }
}
