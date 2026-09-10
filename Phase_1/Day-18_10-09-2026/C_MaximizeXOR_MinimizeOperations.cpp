#include <iostream>
#include <vector>
#include <algorithm>
#include <iomanip>

#define ll long long int
#define INF 2e9

using namespace std;

void solve()
{
    int X, Y;
    cin >> X >> Y;
    int sum = X + Y, rX = 0, rY = 0;
    for (int i = 30; i >= 0; i--)
    {
        if ((sum & (1 << i)) != 0)
        {
            if ((rX | (1 << i)) <= X)
            {
                rX = rX | (1 << i);
            }
            else
            {
                rY = rY | (1 << i);
            }
        }
    }
    cout << sum << " " << X - rX << endl;
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