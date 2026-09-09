#include <iostream>
#include <vector>
using namespace std;

int find(vector<int>& friends, int a) {
    if (friends[a] == a) {
        return a;
    }
    return find(friends, friends[a]);
}

void join (vector<int>& friends, int a, int b) {
    int fndA = find(friends, a);
    int fndB = find(friends, b);
    friends[fndB] = fndA;
}

long long int combination(int n) {
    return (1LL * n * (n - 1)) / 2;
}

int main() {
    int N, M;
    cin >> N >> M;

    vector<int> friends(N + 1, 0);
    vector<pair<int, int>> edgesList(M);
    for (int i = 1; i <= N; i++) {
        friends[i] = i;
   }

    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        join(friends, a, b);
        edgesList[i] = {a, b};
    }

    vector<int> grpCnt(N + 1, 0), edgeCnt(N + 1, 0);

    for (int i = 1; i <= N; i++) {
        grpCnt[find(friends, i)]++;
    }

    for (auto[lt, rt] : edgesList) {
        edgeCnt[find(friends, lt)]++;
    }

    long long int sum = 0;
    for (int i = 1; i <= N; i++) {
        if (grpCnt[i] > 0) {
            sum += combination(grpCnt[i]) - edgeCnt[i];
        }
    }
    cout << sum << endl;
}