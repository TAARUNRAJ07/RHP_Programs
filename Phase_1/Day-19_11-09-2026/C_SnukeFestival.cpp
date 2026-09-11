#include <iostream>
#include <vector>
#include <algorithm>

#define ll long long int
#define INF 2e9

using namespace std;

void getInput(vector<int> &arr, int N)
{
    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }
    sort(arr.begin(), arr.end());
}
void solve()
{
    int N;
    cin >> N;
    vector<int> A(N), B(N), C(N);
    getInput(A, N);
    getInput(B, N);
    getInput(C, N);

    vector<ll> pSum(N, 0);

    // for (int i = 0; i < N; i++)
    // {
    //     auto it = upper_bound(C.begin(), C.end(), B[i]);
    //     if (it != C.end())
    //     {
    //         pSum[i] = C.end() - it;
    //     }
    // }

    // for (int i = 1; i < N; i++)
    // {
    //     pSum[i] += pSum[i - 1];
    // }

    // ll ans = 0;
    // for (int i = 0; i < N; i++)
    // {
    //     auto it = upper_bound(B.begin(), B.end(), A[i]);
    //     if (it != B.end())
    //     {
    //         int m = it - B.begin();
    //         ans += pSum[N - 1] - (m == 0 ? 0 : pSum[m - 1]);
    //     }
    // }
    ll ans = 0;

    for (int i = 0; i < N; i++)
    {
        auto it = upper_bound(C.begin(), C.end(), B[i]);
        auto at = lower_bound(A.begin(), A.end(), B[i]);
        if (it != C.end() || at != A.end())
        {
            int a = C.end() - it + 1;
            int b = at - A.begin() + 1;
            ans += (ll)(a + b);
        }
    }
    cout << ans << endl;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
    // cin >> t;
    while (t--)
    {
        solve();
    }
}