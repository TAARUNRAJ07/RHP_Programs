import java.util.*;

public class CombinationUsingBitwise {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // Generate all masks from 0 to 2^n - 1
        for (int mask = 0; mask < (1 << n); mask++) {

            List<Integer> subset = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                // Check if the i-th bit is set
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }

            result.add(subset);
        }

        return result;
    }

    public static void main(String[] args) {

        CombinationUsingBitwise sol = new CombinationUsingBitwise();

        int[] nums = {1, 2, 3};

        List<List<Integer>> subsets = sol.subsets(nums);

        System.out.println("All Subsets:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}