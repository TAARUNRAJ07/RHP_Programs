#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

using namespace std;

int main()
{
    int N, M;
    cin >> N >> M;

    vector<int> B(N + 1), D(M + 1);
    vector<pair<int, int>> wv(N + M);

    for (int i = 1; i <= N; i++)
    {
        int val;
        cin >> val;
        wv.emplace_back(make_pair(val, -i));
    }
    for (int i = 1; i <= N; i++)
    {
        cin >> B[i];
    }

    for (int i = 1; i <= M; i++)
    {
        int val;
        cin >> val;
        wv.emplace_back(make_pair(val, i));
    }
    for (int i = 1; i <= M; i++)
    {
        cin >> D[i];
    }

    sort(wv.begin(), wv.end(), greater<>());

    multiset<int> ms;

    for (auto [w, idx] : wv)
    {
        if (idx > 0)
        {
            ms.insert(D[idx]);
        }
        else
        {
            auto it = ms.lower_bound(B[-idx]);
            if (it != ms.end())
            {
                ms.erase(it);
            }
            else
            {
                cout << "No" << endl;
                return 0;
            }
        }
    }
    cout << "Yes" << endl;

    return 0;
}