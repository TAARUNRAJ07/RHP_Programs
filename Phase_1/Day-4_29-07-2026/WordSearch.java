
public class WordSearch {
    
    private static boolean dfs(char[][] board, String word, int R, int C, int r, int c, int k) {
        if (word.length() == k) {
            return true;
        }

        if (r < 0 || r >= R || c < 0 || c >= C || board[r][c] != word.charAt(k)) {
            return false;
        }

        char backup = board[r][c];
        board[r][c] = '$';

        boolean found = dfs(board, word, R, C, r+1, c, k+1) || dfs(board, word, R, C, r-1, c, k+1) || dfs(board, word, R, C, r, c+1, k+1) || dfs(board, word, R, C, r, c-1, k+1);

        board[r][c] = backup;
        return found;
    }
    
    public boolean exist(char[][] board, String word) {
        boolean flag = false;
        int R = board.length, C = board[0].length;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                flag = dfs(board, word, R, C, i, j, 0);
                if (flag) return true;
            }
        }
        return false;
    }
}
