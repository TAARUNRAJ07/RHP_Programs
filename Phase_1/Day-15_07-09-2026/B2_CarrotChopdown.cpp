#include <iostream>
#include <vector>

#define ll long long int

using namespace std;

void solve()
{
    int N, M;
    cin >> N >> M;

    vector<int> cnt(M + 1, 0);
    for (int i = 0; i < N; i++)
    {
        int curr;
        cin >> curr;
        cnt[curr]++;
    }

    vector<int> psum(M + 1, 0);
    for (int i = 1; i <= M; i++)
    {
        psum[i] = psum[i - 1] + cnt[i];
    }

    vector<ll> ans(M + 1, 0);

    for (int cut = 1; cut <= min(M, 18); cut++)
    {
        ll maxc = 0;
        for (int x = 1; x <= M; x++)
        {
            ll currc = 0;
            for (ll mul = 1; mul * x <= M; mul++)
            {
                int lt = mul * x;
                int rt = lt + x - 1;

                currc += min(mul, (1ll << cut) - 1) * (psum[min(M, rt)] - psum[lt - 1]);
            }
            if ((1ll << cut) * x <= M)
            {
                currc += cnt[(1ll << cut) * x];
            }
            maxc = max(maxc, currc);
        }

        ans[cut] = maxc;
    }

    for (int cur = 1; cur <= M; cur++)
    {
        cout << ans[min(18, cur)] << (cur == M ? "\n" : " ");
    }
}
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        solve();
    }
}