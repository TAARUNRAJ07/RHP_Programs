import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;

class Sofa {
    int fsr, fsc, ssr, ssc;
    char dir;
    int moves;

    public Sofa(int fsr, int fsc, int ssr, int ssc, char dir, int moves) {
        this.fsr = fsr;
        this.fsc = fsc;
        this.ssr = ssr;
        this.ssc = ssc;
        this.dir = dir;
        this.moves = moves;
    }
}

public class SofaProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char grid[][] = new char[R][C];

        int fsr = -1, fsc = -1, ssr = -1, ssc = -1, sofaCount = 0;

        Queue<Sofa> queue = new LinkedList<>();

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                char ch = sc.next().charAt(0);
                grid[row][col] = ch;
                if (ch == 's') {
                    sofaCount++;
                    if (sofaCount == 1) {
                        fsr = row;
                        fsc = col;
                    }
                    else {
                        ssr = row;
                        ssc = col;
                        Sofa s = new Sofa(fsr, fsc, ssr, ssc, (fsr == ssr) ? 'H' : 'V', 0);
                        queue.add(s);
                    }
                }
            }
        }

        Set<String> visited = new HashSet<>();

        while(!queue.isEmpty()) {
            Sofa s = queue.poll();
            if (grid[s.fsr][s.fsc] == 'S' && grid[s.ssr][s.ssc] == 'S') {
                System.out.println(s.moves);
                return;
            }

            if (s.dir == 'H') {
                // Check if Sofa can be dragged to the right
                if (s.ssc < C - 1 && grid[s.ssr][s.ssc + 1] != 'H') {
                    if (canAdd(s.ssr, s.ssc, s.ssr, s.ssc + 1, visited)) {
                        queue.add(new Sofa(s.ssr, s.ssc, s.ssr, s.ssc + 1, 'H', s.moves + 1));
                    }
                }
                // Check if Sofa can be dragged to the left
                if (s.fsc > 0 && grid[s.fsr][s.fsc-1] != 'H') {
                    if (canAdd(s.fsr, s.fsc - 1, s.fsr, s.fsc, visited)) {
                        queue.add(new Sofa(s.fsr, s.fsc - 1, s.fsr, s.fsc, 'H', s.moves + 1));
                    }
                }

                //Check if Sofa can be dragged to top
                if (s.fsr  > 0 && grid[s.fsr - 1][s.fsc] != 'H' && grid[s.ssr - 1][s.ssc] != 'H') {
                    if (canAdd(s.fsr - 1, s.fsc, s.ssr - 1, s.ssc, visited)) {
                        queue.add(new Sofa(s.fsr - 1, s.fsc, s.ssr - 1, s.ssc, 'H', s.moves + 1));
                    }
                }

                //Check if Sofa can be dragged to bottom
                if (s.fsr < R - 1 && grid[s.fsr + 1][s.fsc] != 'H' && grid[s.ssr + 1][s.ssc] != 'H') {
                    if (canAdd(s.fsr + 1, s.fsc, s.ssr + 1, s.ssc, visited)) {
                        queue.add(new Sofa(s.fsr + 1, s.fsc, s.ssr + 1, s.ssc, 'H', s.moves + 1));
                    }
                }

                //Rotate sofa to vertical
                if (s.fsr > 0 && grid[s.fsr - 1][s.fsc] != 'H' && grid[s.ssr - 1][s.ssc] != 'H') {
                    // First seat is going to the top of second seat clockwise
                    if (canAdd(s.ssr-1, s.ssc, s.ssr, s.ssc, visited)) {
                        queue.add(new Sofa(s.ssr-1, s.ssc, s.ssr, s.ssc, 'V', s.moves + 1));
                    }
                    //Second seat is going to the top of first seat anti-clockwise
                    if (canAdd(s.fsr, s.fsc, s.fsr - 1, s.fsc, visited)) {
                        queue.add(new Sofa(s.fsr, s.fsc, s.fsr - 1, s.fsc, 'V', s.moves + 1));
                    }
                }
                if (s.fsr < R - 1 && grid[s.fsr + 1][s.fsc] != 'H' && grid[s.ssr + 1][s.ssc] != 'H') {
                    // First seat is going to the bottom of second seat anti-clockwise
                    if (canAdd(s.ssr + 1, s.ssc, s.ssr, s.ssc, visited)) {
                        queue.add(new Sofa(s.ssr + 1, s.ssc, s.ssr, s.ssc, 'V', s.moves + 1));
                    }
                    //Second seat is going to the bottom of first seat clockwise
                    if (canAdd(s.fsr, s.fsc, s.fsr + 1, s.fsc, visited)) {  
                        queue.add(new Sofa(s.fsr, s.fsc, s.fsr + 1, s.fsc, 'V', s.moves + 1));
                    }
                }

            }
            else{
				// drag right
                if (s.fsc < C - 1 && grid[s.fsr][s.fsc + 1] != 'H' && grid[s.ssr][s.ssc + 1] != 'H') {
                    if (canAdd(s.fsr, s.fsc + 1, s.ssr, s.ssc + 1, visited)) {
                        queue.add(new Sofa(s.fsr, s.fsc + 1, s.ssr, s.ssc + 1,'V', s.moves + 1));
                    }
                }

                // drag left
                if (s.fsc > 0 && grid[s.fsr][s.fsc - 1] != 'H' && grid[s.ssr][s.ssc - 1] != 'H') {
                    if (canAdd(s.fsr, s.fsc - 1, s.ssr, s.ssc - 1, visited)){
                        queue.add(new Sofa(s.fsr, s.fsc - 1, s.ssr, s.ssc - 1, 'V', s.moves + 1));
                    }
                }

                // drag up
                if (s.fsr > 0 && grid[s.fsr - 1][s.fsc] != 'H') {
                    if (canAdd(s.fsr - 1, s.fsc, s.ssr - 1, s.ssc, visited)) {
                        queue.add(new Sofa(s.fsr - 1, s.fsc,s.ssr - 1, s.ssc,'V', s.moves + 1));
                    }
                }

                // drag down
                if (s.ssr < R - 1 && grid[s.ssr + 1][s.ssc] != 'H') {
                    if (canAdd(s.fsr + 1, s.fsc, s.ssr + 1, s.ssc, visited)) {
                        queue.add(new Sofa(s.fsr + 1, s.fsc, s.ssr + 1, s.ssc,'V', s.moves + 1));
                    }
                }
                
                // Rotation using the 2x2 square on the left
                if (s.fsr > 0 && s.fsc > 0 && grid[s.fsr][s.fsc - 1] != 'H' && grid[s.ssr][s.fsc - 1] != 'H' && grid[s.ssr][s.ssc] != 'H') {
                    if (canAdd(s.fsr, s.fsc - 1, s.fsr, s.fsc, visited)) {
                        queue.add(new Sofa(s.fsr, s.fsc - 1, s.fsr, s.fsc, 'H', s.moves + 1));
                    }
                    if (canAdd(s.ssr, s.fsc - 1, s.ssr, s.fsc, visited)) {
                        queue.add(new Sofa(s.ssr, s.fsc - 1, s.ssr, s.fsc, 'H', s.moves + 1));
                    }
                }

                // Rotation 
                if (s.fsr < R - 1 && s.fsc < C - 1 && grid[s.fsr][s.fsc + 1] != 'H' && grid[s.ssr][s.fsc + 1] != 'H' && grid[s.ssr][s.ssc] != 'H') {
                    if (canAdd(s.fsr, s.fsc, s.fsr, s.fsc + 1, visited)) {
                        queue.add(new Sofa(s.fsr, s.fsc, s.fsr, s.fsc + 1, 'H', s.moves + 1));
                    }
                    if (canAdd(s.ssr, s.fsc, s.ssr, s.fsc + 1, visited)) {
                        queue.add(new Sofa(s.ssr, s.fsc, s.ssr, s.fsc + 1, 'H', s.moves + 1));
                    }
                }

            }
        }
        System.out.println("Impossible");
        sc.close();
    }

    static final String DELIM = "|";
    private static boolean canAdd(int fsr, int fsc, int ssr, int ssc, Set<String> visited
    ) {
        StringBuilder sb = new StringBuilder();
        sb.append(fsr).append(DELIM).append(fsc).append(DELIM);
        sb.append(ssr).append(DELIM).append(ssc);
        String key = sb.toString();
        if (visited.contains(key)) {
            return false;
        }
        visited.add(key);
        return true;
    }
}