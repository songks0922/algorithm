#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  string s1, s2;
  int cnt = 1;

  while(1) {
    cin >> s1 >> s2;
    if(s1 == "END" && s2 == "END") break;

    sort(s1.begin(), s1.end());
    sort(s2.begin(), s2.end());

    cout << "Case " << cnt++ << ": " << (s1 == s2 ? "same" : "different") << '\n';
  }
  return 0;
}