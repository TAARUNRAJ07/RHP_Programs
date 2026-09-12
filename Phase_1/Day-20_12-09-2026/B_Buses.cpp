#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <iomanip>

#define ll long long int
#define INF 2e9

using namespace std;

struct Bus
{
    ll lt, rt;
    double time;
    friend bool operator<(Bus a, Bus b)
    {
        if (a.lt != b.lt)
        {
            return a.lt < b.lt;
        }
        return a.time < b.time;
    }
} buses[200000];

void solve()
{
    ll n, m, l, x, y, p;
    cin >> n >> m >> l >> x >> y;
    for (int i = 0; i < n; i++)
    {
        cin >> buses[i].lt >> buses[i].rt;
        buses[i].time = (double)(buses[i].rt - buses[i].lt) / (double)x + (double)(l - buses[i].rt) / (double)y;
    }
    sort(buses, buses + n);

    for (int i = 0; i < n - 1; i++)
    {
        buses[i + 1].time = min(buses[i + 1].time, buses[i].time);
    }
    double ans;
    for (int c = 1; c <= m; c++)
    {
        cin >> p;
        ans = (double)(l - p) / (double)y;
        int bl = 0, br = n;
        bool f = false;
        while (bl < br)
        {
            int mid = (bl + br) / 2;
            if (buses[mid].lt <= p)
            {
                f = true;
                if (bl == mid)
                {
                    break;
                }
                bl = mid;
            }
            else
            {
                br = mid;
            }
        }
        if (f)
        {
            ans = min(ans, buses[bl].time);
        }
        cout << ans << endl;
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
    // cin >> t;
    cout << setprecision(11);
    while (t--)
    {
        solve();
    }
}