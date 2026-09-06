import java.util.*;

class Pair {
    int first, second;
    Pair(int f,int s) {
        this.first = f;
        this.second = s;
    }
}

class BomberMad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();
        ArrayList<String> list = new ArrayList<>();
        boolean[][] vis = new boolean[R][C];
        for(int i = 0; i < R; i++) {
            list.add(new String());
            list.set(i, sc.nextLine());
        }
        boolean[] br = new boolean[R];
        boolean[] bc = new boolean[C];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(list.get(i).charAt(j) == '#') {
                    br[i] = bc[j] = true;
                }
            } 
        }
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(br[i] != true && bc[j] != true) {
                    queue.add(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }
        int round = 0,ans = 0;
        final int path[] = {0,1,0,-1,0};
        while(!queue.isEmpty() && round <= K) {
            int size = queue.size();
            ans += queue.size();
            while(size-- != 0) {
                Pair p = queue.poll();
                for(int i = 0; i < path.length - 1; i++) {
                    int ar = p.first + path[i];
                    int ac = p.second + path[i+1];
                    if(ar >= 0 && ar < R && ac >= 0 && ac < C)
                        if(vis[ar][ac] != true && list.get(ar).charAt(ac) == '.') {
                            queue.add(new Pair(ar,ac));
                            vis[ar][ac] = true;
                        }
                }
            }
            round++;
        }
        System.out.println(ans);
    }
}