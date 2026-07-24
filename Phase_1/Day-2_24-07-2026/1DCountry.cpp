#include <iostream>
#include <vector>
using namespace std;

int main() {
    long long int N;
    cin >> N;

    vector<long long int> coordinate(N+1, 0);
    for (long long int i = 1; i <= N; ++i) {
        cin >> coordinate[i];
    }

    int n = coordinate[coordinate.size() - 1];
    vector<int> villagers(N+1, 0);

    for (int i = 1; i <= N; ++i) {
        cin >>  villagers[i];
    }

    vector<long long int > prefixSum(n + 1, 0);
    for(int i = 1; i <= N; i++) {
        prefixSum[coordinate[i]] = villagers[i];
    }


    for(long long int i = 1; i <= n; i++) {
       prefixSum[i] += prefixSum[i - 1];
    }

    long long int q;
    cin >> q;

    for (long long int i = 0; i < q; ++i) {
        long long int L, R;
        cin >> L >> R;
        R = R < n ? R : n;
        cout << prefixSum[R] - prefixSum[L - 1] << endl;
    }

    return 0;
}