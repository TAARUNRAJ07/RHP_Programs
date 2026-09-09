#include <iostream>
#include <vector>
#define ll long long int

using namespace std;

void solve()
{
    int N;
    cin >> N;
    vector<int> A(N);
    vector<int> B(N);
    for (int i = 0; i < N; i++)
    {
        cin >> A[i];
    }
    for (int i = 0; i < N; i++)
    {
        cin >> B[i];
    }

    ll aM = 0, bM = 0;
    for (int i = 0; i < N; i++)
    {
        if (A[i] > B[i])
        {
            aM += A[i] - B[i];
        }
        else
        {
            bM += B[i] - A[i];
        }
    }
    if (aM == 0)
    {
        cout << "No" << endl;
        return;
    }
    ll aMoreWeight = (bM / aM) + 2;
    vector<ll> ans;
    for (int i = 0; i < N; i++)
    {
        if (A[i] <= B[i])
        {
            ans.push_back(1);
        }
        else
        {
            ans.push_back(aMoreWeight);
        }
    }
    cout << "Yes" << endl;
    for (ll wt : ans)
    {
        cout << wt << " ";
    }
    cout << endl;
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