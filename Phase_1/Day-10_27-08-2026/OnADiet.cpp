#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n, m;
    long long k;
    cin >> n >> m >> k;

    vector<long long> a(n);
    vector<bool> eaten(n, false);

    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }

    long long sum = 0;

    for (int i = 0; i < n; i++)
    {
        if (i >= m && eaten[i - m])
            sum -= a[i - m];

        if (sum + a[i] <= k)
        {
            eaten[i] = true;
            sum += a[i];
            cout << "Yes\n";
        }
        else
        {
            cout << "No\n";
        }
    }

    return 0;
}