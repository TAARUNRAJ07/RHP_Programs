import java.util.*;

public class WordSearch2 {
    private static boolean dfs(char[][] board, String word, int R, int C, int r, int c, int k) {
        if (k == word.length()) {
            return true;
        }

        char backup = board[r][c];
        board[r][c] = '$';

        int[] diff = {0, 1, 0, -1, 0};
        
        for (int i = 0; i < 4; i++) {
            int ar = r + diff[i];
            int ac = c + diff[i+1];
            if (ar >= 0 && ar < R && ac >= 0 && ac < C && backup == word.charAt(k)) {
                boolean flag = dfs(board, word, R, C, ar, ac, k+1);
                if (flag) return true;
            }
        }
        board[r][c] = backup;
        return false;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        int R = board.length, C = board[0].length, L = words.length;

        List<String> res = new ArrayList<>();

        for (int k = 0; k < L; k++) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] == words[k].charAt(0)) {
                        boolean flag = dfs(board, words[k], R, C, i, j, 1);
                        if (flag) res.add(words[k]);
                    }
                }
            }
        }
        return res;
    }
}
