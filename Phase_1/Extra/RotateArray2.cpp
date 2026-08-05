#include <vector>
using namespace std;

class Solution
{
public:
    void rotate(vector<int> &nums, int k)
    {
        int N = nums.size();
        k = k % N;

        vector<int> arr(N);
        arr = nums;

        for (int i = 0; i < N; i++)
        {
            int idx = (i + N - k) % N;
            nums[i] = arr[idx];
        }
    }
};