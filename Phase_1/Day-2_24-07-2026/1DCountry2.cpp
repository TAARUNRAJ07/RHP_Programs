#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int N;
    cin >> N;
    vector<long long int> loc(N);
    vector<long long int> prefixSum(N + 1, 0);

    for (int i = 0; i < N; i++) {
        cin >> loc[i];
    }

    for (long long int i = 1; i <= N; i++) {
        long long int ppl;
        cin >> ppl;
        prefixSum[i] = prefixSum[i - 1] + ppl;
    }
    int q;
    cin >> q;

    while(q--) {
        int lt, rt;
        cin >> lt >> rt;
        int L = lower_bound(loc.begin(), loc.end(), lt) - loc.begin();
        int R = upper_bound(loc.begin(), loc.end(), rt) - loc.begin();
        cout << prefixSum[R] - prefixSum[L] << endl;

    }
}