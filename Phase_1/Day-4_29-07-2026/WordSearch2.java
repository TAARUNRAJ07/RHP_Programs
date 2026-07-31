import java.util.*;

class Trie {
    String word;
    Trie chars[] = new Trie[26];
}
public class WordSearch2 {

    private void buildTrie(Trie t, String word, int idx) {
        if (idx == word.length()) return;

        int chidx = word.charAt(idx) - 'a';
        if (t.chars[chidx] == null) {
            t.chars[chidx] = new Trie();
        }
        Trie ct = t.chars[chidx];
        if (idx == word.length() - 1) {
            ct.word = word;
        }
        buildTrie(ct, word, idx + 1);
    }

    int[] d = {0, 1, 0, -1, 0};
    private static boolean dfs(char[][] board, String word, List<String> res, Trie t, int R, int C, int r, int c, int k) {
        return true;
    }
    
    public List<String> findWords(char[][] board, String[] words) {

        Trie root = new Trie();
        for (String w : words) buildTrie(root, w, 0);

        int R = board.length, C = board[0].length, L = words.length;
        boolean vis[][] = new boolean[R][C];
        List<String> res = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dfs(board, words[0], res, root, R, C, i, j, 1);

            }
        }
        
        return res;
    }
}
