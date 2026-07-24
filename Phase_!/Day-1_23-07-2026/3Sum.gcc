class Solution {
public:

    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int N = nums.size();
        vector<vector<int>> ans;
        for (int i = 0; i <= N - 3; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int lt = i + 1, rt = N - 1;
            while (lt < rt) {
                int sum = nums[i] + nums[lt] + nums[rt];
                if (sum == 0) {
                    vector<int> t = {nums[i], nums[lt], nums[rt]};
                    ans.push_back(t);
                    while(lt + 1 < N && nums[lt+1] == nums[lt]) {
                        lt++;
                    }
                    lt++;
                }
                else if (sum < 0) {
                    lt++;
                }
                else {
                    rt--;
                }
            }
        }
        return ans;
    }
};