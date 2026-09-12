#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <iomanip>

#define ll long long int
#define INF 2e9

using namespace std;

void solve()
{
    int g, c, l;
    cin >> g >> c >> l;
    int mx = max(g, max(c, l)), mn = min(g, min(c, l));
    if (abs(mx - mn) >= 10)
    {
        cout << "check again";
    }
    else
    {
        int mid;
        if ((g >= c && g <= l) || (g <= c && g >= l))
        {
            mid = g;
        }
        else if ((c >= l && c <= g) || (c <= l && c >= g))
        {
            mid = c;
        }
        else if ((l >= c && l <= g) || (l <= c && l >= g))
        {
            mid = l;
        }
        cout << "final " << mid << endl;
    }
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