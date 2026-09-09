#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    // Write C++ code here
    int N;
    cin >> N;
    vector<int> a(N), ans;
    for(int i = 0; i < N; i++) {
        cin >> a[i];
    }
    sort(a.begin(), a.end());
    long long int cfwd = 0;
    for (int ctr = 1; ctr <= a[N-1]; ctr++) {
        auto it = lower_bound(a.begin(), a.end(), ctr);
        int cnt = a.end() - it;
        cfwd += cnt;
        ans.push_back(cfwd % 10);
        cfwd = cfwd / 10;
    }
    
    while(cfwd != 0) {
        ans.push_back(cfwd % 10);
        cfwd = cfwd / 10;
    }
    
    reverse(ans.begin(), ans.end());
    for (int v : ans) {
        cout << v;
    }
    return 0;
}