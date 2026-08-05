import java.util.Arrays;

public class RotateArray2 {
    public void rotate(int[] nums, int k) {
        int N = nums.length;
        k = k % N;

        int[] arr = new int[N];
        arr = Arrays.copyOf(nums, N);
        
        for (int i = 0; i < N; i++) {
            int idx = (i + N - k) % N;
            nums[i] = arr[idx];
        }
    }
}
