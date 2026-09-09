#include <iostream>
#include <vector>
#define ll long long int
using namespace std;

int main()
{
    ll N, R = 0, C = 0;
    cin >> N;
    vector<ll> a(N + 1);
    for (ll i = 1; i <= N; i++)
    {
        cin >> a[i];
    }

    for (ll i = 1; i <= N; i++)
    {
        if (i == a[i])
            R++;
        else if (i == a[a[i]])
            C++;
    }
    ll ans = C / 2 + ((R * (R - 1)) / 2);

    cout << ans;

    return 0;
}