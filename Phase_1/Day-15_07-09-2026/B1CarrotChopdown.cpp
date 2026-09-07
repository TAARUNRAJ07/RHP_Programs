#include <iostream>
#include <vector>
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

    int ans = 0;
    for (int i = 1; i <= M; i++)
    {
        int total = psum[M] - psum[i - 1];
        if (2 * i <= M)
        {
            total += cnt[2 * i];
        }
        ans = max(ans, total);
    }

    cout << ans << endl;
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