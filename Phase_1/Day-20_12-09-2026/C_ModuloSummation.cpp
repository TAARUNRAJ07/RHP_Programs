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
    int n, ans = 0;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int val;
        cin >> val;
        ans += val;
    }
    cout << (ans - n) << endl;
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