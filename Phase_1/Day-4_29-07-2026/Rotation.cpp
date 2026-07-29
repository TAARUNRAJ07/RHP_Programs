#include <iostream>
#include <string>
using namespace std;

int main() {
    int N, Q;
    cin >> N >> Q;
    string S;
    cin >> S;
    int pos = N - 1;

    while(Q--) {
        int c, x;
        cin >> c >> x;
        x = x % N;
        if (c == 1) {
            pos = (pos -x);
            if (pos < 0) {
                pos += N;
            }
        }
        else {
            int index = (x + pos) % N;
            cout << S[index] << endl; 
        }
    }
    return 0;
}