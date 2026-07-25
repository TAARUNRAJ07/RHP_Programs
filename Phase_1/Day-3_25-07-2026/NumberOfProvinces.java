import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {

    private int find(int[] ldr, int a) {
        if (ldr[a] != a) {
            ldr[a] = find(ldr, ldr[a]);
        }
        return ldr[a];
    }

    private void join(int[] ldr, int lt, int rt) {
        ldr[find(ldr, rt)] = find(ldr, lt);
    }
    public int findCircleNum(int[][] g) {
        int N =g.length;
        int[] ldr = new int[N+1];
        for (int c = 1; c <= N; c++) {
            ldr[c] = c;
        }
        for(int city = 0; city < N; city++) {
            for (int oc = 0; oc < N; oc++) {
                if (city == oc) {
                    continue;
                }
                if (g[city][oc] == 1) {
                    join(ldr, city+1, oc+1);
                }
            }
        }

        Set<Integer> st = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            st.add(find(ldr, i));
        }
        
        return st.size();

    }

}
