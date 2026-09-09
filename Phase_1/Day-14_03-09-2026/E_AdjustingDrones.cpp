#include <iostream>
using namespace std;
void solve(){
  int n,k;
  cin>>n>>k;
  int c[3*n+1]={0};
  for(int i=0;i<n;i++){
    int y;
    cin>>y;
    c[y]++;
  }
  int m = 0;
  for(int i=0;i<=2*n;i++){
    int cur = i;
    while(c[cur] >k){
       c[cur+1]+=c[cur]-1;
      c[cur]=1;
      cur++;
    }
    m = max(m,cur-i);
  }
  cout<<m<<endl;
}
using namespace std;
int main() {
    int n;
  cin>>n;
  while(n--){
    solve();
  }
}