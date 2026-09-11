#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

#define ll long long int
#define INF 2e9

using namespace std;

void solve()
{
    int n;
    cin >> n;
    string str;
    cin >> str;
    if (str[0] == '0' || str.contains("00"))
    {
        cout << "-1" << endl;
        return;
    }
    int res = -1;
    if (str.contains("+-") || str.contains("-+"))
    {
        if (str.contains("+--+") || str.contains("-++-"))
        {
            res = 3;
        }
        else
        {
            res = 2;
        }
    }
    else
    {
        res = 1;
        for (int i = 0; i < n; i++)
        {
            if (str[i] == '0' && i % 2 == 0)
            {
                res = 2;
                break;
            }
        }
    }
    cout << res << endl;
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
