#include <iostream>
#include <string>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, cnt = 0;
  int idx = 0;
  string s;
  
  cin >> n >> s;

  while (s.find("LL", idx) != string::npos) {
    idx = s.find("LL", idx);
    idx += 2;
    cnt++;
  }
  int ans = n + 1 - cnt;
  cout << ((ans > n) ? n : ans) << '\n';
  return 0;
}