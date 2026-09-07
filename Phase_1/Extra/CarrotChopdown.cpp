#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void solve()
{
    int n, m;
    cin >> n >> m;
    vector<int> arr(n);
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    vector<int> chopdown(m + 1, 0);

    for (int i = 1; i <= m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (arr[j] == 2 * i)
            {
                chopdown[i] += 2;
            }
            else if (arr[j] >= i)
            {
                chopdown[i] += 1;
            }
        }
    }

    cout << *max_element(chopdown.begin(), chopdown.end()) << endl;
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