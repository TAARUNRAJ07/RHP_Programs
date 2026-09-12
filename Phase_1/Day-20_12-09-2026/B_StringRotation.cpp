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
    string s, t;
    cin >> s;
    cin >> t;
    string tos = s + s;
    if (tos.contains(t))
    {
        cout << "Yes" << endl;
    }
    else
    {
        cout << "No" << endl;
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