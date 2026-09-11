#include <iostream>
#include <vector>
#include <algorithm>

#define ll long long int
#define INF 2e9

using namespace std;

vector<int> getInput(int N) {
    vector<int> arr(N);
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }
    return arr;
}
void solve() {
    int N;
    cin >> N;
    vector<int> A(N), B(N), C(N);
    A = getInput(N);
    B = getInput(N);
    C = getInput(N);

    


}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
    // cin >> t;
    while(t--) {
        solve();
    }
}