#include <iostream>
#include <vector>
#include <algorithm>
#include <map>

#define ll long long int
#define INF 2e9

using namespace std;

void solve()
{
    int N, val;
    cin >> N;
    vector<int> arr;
    for (int i = 0; i < N; i++)
    {
        cin >> val;
        auto it = find(arr.begin(), arr.end(), val);
        if (it != arr.end())
        {
            arr.erase(it);
        }
        else
        {
            arr.push_back(val);
        }
    }
    cout << arr.size() << endl;

    // map<int, int> m;
    // for (int i = 0; i < N; i++) {
    //     cin >> val;
    //     m[val]++;
    // }
    // int count = 0;
    // for (auto [k, v] : m) {
    //     if (v % 2 == 1) {
    //         count++;
    //     }
    // }
    // cout << count << endl;
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