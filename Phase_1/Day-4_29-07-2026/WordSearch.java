
public class WordSearch {
    
    private static boolean dfs(char[][] board, String word, int R, int C, int r, int c, int k) {
        if (word.length() == k) {
            return true;
        }

        char backup = board[r][c];
        board[r][c] = '$';

        int[] diff = {0, 1, 0, -1, 0};
        
        for (int i = 0; i < 4; i++) {
            int ar = r + diff[i], ac = c + diff[i+1];
            if (ar >= 0 && ar < R && ac >= 0 && ac < C && backup == word.charAt(k)) {
                boolean flag = dfs(board, word, R, C, ar, ac, k+1);
                if (flag) return true;
            }
        }
        board[r][c] = backup;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        boolean flag = false;
        int R = board.length, C = board[0].length;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == word.charAt(0)) {
                    flag = dfs(board, word, R, C, i, j, 1);
                    if (flag) return true;
                }
            }
        }

        return false;
    }
}
