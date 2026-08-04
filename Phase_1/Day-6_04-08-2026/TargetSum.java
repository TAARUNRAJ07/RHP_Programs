import java.util.*;

public class TargetSum {
    private List<Integer> ad(List<Integer> v, int num) {
        List<Integer> out = new ArrayList<>();
        for (int val : v) {
            out.add(val + num);
            out.add(val - num);
        }
        return out;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int N = nums.length;
        List<Integer> cur = new ArrayList<>();
        cur.add(0);

        for (int i = 0; i < N; i++) {
            cur = ad(cur, nums[i]);
        }

        int c = 0;
        for (int val : cur) {
            if (val == target) {
                c++;
            }
        }
        return c;
    }
}