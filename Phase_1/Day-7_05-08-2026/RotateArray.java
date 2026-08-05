class RotateArray {
    private void reverse(int[] nums, int lt, int rt) {
        while(lt < rt) {
            int temp = nums[lt];
            nums[lt++] = nums[rt];
            nums[rt--] = temp;
        }
    }
    public void rotate(int[] nums, int k) {
        int N = nums.length;
        k = k % N;

        reverse(nums, 0, N - k - 1);
        reverse(nums, N - k, N - 1);
        reverse(nums, 0, N - 1);
    }
}