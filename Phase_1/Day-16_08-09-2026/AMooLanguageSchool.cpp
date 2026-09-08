#include <iostream>
#include <vector>
using namespace std;

void solve()
{
    int n, k;
    cin >> n >> k;
    string s;
    cin >> s;

    int f = n / k;

    vector<bool> own(f, false);
    for (unsigned int i = 0; i < n; i++)
    {
        if (s[i] == '0')
        {
            int fidx = i / k;
            own[fidx] = true;
        }
    }
    int count = 0;
    for (int i = 0; i < f; i++)
    {
        if (!own[i])
        {
            count++;
        }
    }
    cout << count << endl;
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