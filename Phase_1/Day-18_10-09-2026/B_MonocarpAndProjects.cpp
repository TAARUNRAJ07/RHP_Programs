#include <iostream>
#define ll long long int
using namespace std;

void solve()
{
    ll x, y, k;
    cin >> x >> y >> k;
    ll ans = 0ll;
    for (ll i = 0ll; i < k; i++)
    {
        int rem = (y + i) % (x + i);
        if (rem == y - x)
        {
            ans += (k - i) * (y - x);
            break;
        }
        ans += rem;
    }
    cout << ans << endl;
}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;
    while (t--)
    {
        solve();
    }
}