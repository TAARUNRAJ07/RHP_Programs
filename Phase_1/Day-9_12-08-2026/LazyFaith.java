import java.io.*;
import java.util.*;

public class LazyFaith {

    static final long INF = 1_000_000_000_000L;

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0) {
                    return -1;
                }
            }

            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;

            do {
                c = read();
            } while (c <= ' ');

            boolean negative = false;

            if (c == '-') {
                negative = true;
                c = read();
            }

            long result = 0;

            while (c > ' ') {
                result = result * 10 + (c - '0');
                c = read();
            }

            return negative ? -result : result;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    static int lowerBound(long[] arr, long target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();

        int a = fs.nextInt();
        int b = fs.nextInt();
        int q = fs.nextInt();

        long[] shrine = new long[a];
        long[] temple = new long[b];

        for (int i = 0; i < a; i++) {
            shrine[i] = fs.nextLong();
        }

        for (int i = 0; i < b; i++) {
            temple[i] = fs.nextLong();
        }

        Arrays.sort(shrine);
        Arrays.sort(temple);

        StringBuilder output = new StringBuilder();

        while (q-- > 0) {

            long pt = fs.nextLong();

            long ans = INF;

            int rightShrine = lowerBound(shrine, pt);
            int rightTemple = lowerBound(temple, pt);

            int leftShrine = rightShrine - 1;
            int leftTemple = rightTemple - 1;

            if (rightShrine < a && rightTemple < b) {
                ans = Math.min(
                    ans,
                    Math.max(
                        shrine[rightShrine],
                        temple[rightTemple]
                    ) - pt
                );
            }

            if (leftShrine >= 0 && leftTemple >= 0) {
                long curr = pt - Math.min(
                    shrine[leftShrine],
                    temple[leftTemple]
                );

                ans = Math.min(ans, curr);
            }

            if (rightShrine < a && leftTemple >= 0) {
                long curr =
                    Math.min(
                        pt - temple[leftTemple],
                        shrine[rightShrine] - pt
                    )
                    + (shrine[rightShrine] - temple[leftTemple]);

                ans = Math.min(ans, curr);
            }

            if (leftShrine >= 0 && rightTemple < b) {
                long curr =
                    Math.min(
                        temple[rightTemple] - pt,
                        pt - shrine[leftShrine]
                    )
                    + (temple[rightTemple] - shrine[leftShrine]);

                ans = Math.min(ans, curr);
            }

            output.append(ans).append('\n');
        }

        System.out.print(output);
    }
}
