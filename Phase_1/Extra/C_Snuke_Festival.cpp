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

    vector<ll> pSum(N + 1, 0);

    for (int i = 0; i < N; i++)
    {
        int c = 0;
        for (int j = 0; j < N; j++)
        {
            if (B[i] < C[j])
            {
                c++;
            }
        }
        pSum[i + 1] = pSum[i] + c;
    }

    ll ans = 0;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (A[i] < B[j])
            {
                ans += (pSum[N] - pSum[j]);
                break;
            }
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