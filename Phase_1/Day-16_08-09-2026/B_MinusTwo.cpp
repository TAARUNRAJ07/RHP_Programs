#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void solve()
{
    int n;
    cin >> n;

    vector<int> cnt(3, 0);
    for (int i = 0; i < n; i++)
    {
        int val;
        cin >> val;
        if (val % 2 == 1)
        {
            cnt[0]++;
        }
        else if (val % 4 == 0)
        {
            cnt[2]++;
        }
        else
        {
            cnt[1]++;
        }
    }

    cout << *max_element(cnt.begin(), cnt.end()) << endl;
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