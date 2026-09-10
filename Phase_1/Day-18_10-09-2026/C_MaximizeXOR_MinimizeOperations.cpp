#include <iostream>
#include <vector>
#include <algorithm>
#include <iomanip>

#define ll long long int
#define INF 2e9

using namespace std;

void solve()
{
    int x, y;
    cin >> x >> y;
    int sum = x + y, rx = 0, ry = 0;
    for (int i = 30; i >= 0; i--)
    {
        if ((sum & (1 << i)) != 0)
        {
            if ((rx | (1 << i)) <= x)
            {
                rx = rx | (1 << i);
            }
            else
            {
                ry = ry | (1 << i);
            }
        }
    }
    cout << sum << " " << x - rx << endl;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
    cin >> t;
    while (t--)
    {
        solve();
    }
}