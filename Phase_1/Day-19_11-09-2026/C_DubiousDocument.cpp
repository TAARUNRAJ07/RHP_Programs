#include <iostream>
#include <vector>
#include <algorithm>

#define ll long long int
#define INF 2e9

using namespace std;

void solve()
{
    int N;
    cin >> N;
    vector<int> arr(26, 50);
    for (int i = 1; i <= N; i++)
    {
        string s;
        cin >> s;
        vector<int> cur(26, 0);
        for (char ch : s)
        {
            cur[(ch - 'a')]++;
        }
        for (int i = 0; i < 26; i++)
        {
            arr[i] = min(arr[i], cur[i]);
        }
    }
    for (int i = 0; i < 26; i++)
    {
        while (arr[i]--)
        {
            cout << (char)('a' + i);
        }
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