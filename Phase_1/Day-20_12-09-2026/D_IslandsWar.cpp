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
    int N, M;
    cin >> N >> M;
    vector<pair<int, int>> islands(M);
    for (int i = 0; i < M; i++)
    {
        int lt, rt;
        cin >> lt >> rt;
        islands[i] = make_pair(rt, lt);
    }
    sort(islands.begin(), islands.end());
    int c = 0, rtMost = -5;
    for (auto [rt, lt] : islands)
    {
        if (lt >= rtMost)
        {
            c++;
            rtMost = rt;
        }
    }
    cout << c << endl;
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