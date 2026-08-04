#include <iostream>
#include <vector>
using namespace std;

vector<int> add(vector<int> &nums, int num) {
    vector<int> out;
    for (int i = 0; i < nums.size(); i++) {
        out.push_back(nums[i] + num);
        out.push_back(nums[i] - num);
    }
    return out;
}
int find(vector<int> &nums, int target) {
    int N = nums.size();
    vector<int> out = {0};
    int c = 0;
    for (int i = 0; i < N; i++) {
        out = add(out, nums[i]);
    }

    for (int i = 0; i < out.size(); i++) {
        if (out[i] == target) {
            c++;
        }
    }
    return c;

}

int main() {

}