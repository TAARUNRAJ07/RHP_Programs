class BinarySearch {
    public int search(int[] nums, int target) {
        int lt = 0;
        int rt = nums.length - 1;
        while(lt + 1 < rt) {
            int mid = lt + (rt - lt) / 2;
            if (nums[mid] < target) {
                lt = mid;
            }
            else {
                rt = mid;
            }
        }
        return nums[lt] == target ? lt : nums[rt] == target ? rt : 1;
    }
}