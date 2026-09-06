import java.io.*;
import java.util.*;

public class IncDecXor {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];

        ArrayList<Integer> posv = new ArrayList<>();
        ArrayList<Integer> newposv = new ArrayList<>();

        int ans = 0;

        StringBuilder sb = new StringBuilder();

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());

            int qt = Integer.parseInt(st.nextToken());

            if (qt == 1) {
                int pos = Integer.parseInt(st.nextToken());

                ans ^= arr[pos];
                arr[pos]++;
                ans ^= arr[pos];

                if (arr[pos] == 1) {
                    posv.add(pos);
                }

            } else {

                for (int pos : posv) {
                    ans ^= arr[pos];
                    arr[pos]--;

                    if (arr[pos] > 0) {
                        ans ^= arr[pos];
                        newposv.add(pos);
                    }
                }

                posv = new ArrayList<>(newposv);
                newposv.clear();
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}