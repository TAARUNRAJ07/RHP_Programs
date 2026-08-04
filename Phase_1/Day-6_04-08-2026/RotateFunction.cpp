#include <vector>
#include <algorithm>
using namespace std;

class Solution
{
public:
    int maxRotateFunction(vector<int> &nums)
    {
        int n = nums.size();
        long S = 0, res = 0;

        for (int i = 0; i < n; i++)
        {
            S += nums[i];
            res += nums[i] * i;
        }

        long mx = res;
        for (int i = (n - 1); i > 0; i--)
        {
            res = res + S - nums[i] * n;
            mx = max(mx, res);
        }
        return (int)mx;
    }
};