import java.util.*;

public class LCSWithEqual01 {

    public static int longestSub(String s) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Sum 0 occurs before the string starts
        map.put(0, -1);

        int csum = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1') {
                csum += 1;
            } else if (s.charAt(i) == '0') {
                csum -= 1;
            }

            if (map.containsKey(csum)) {
                maxLen = Math.max(maxLen, i - map.get(csum));
            } else {
                map.put(csum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(longestSub(str));

        sc.close();
    }
}