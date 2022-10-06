#include <iostream>
#include <string>
#include <map>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int n, ans = 0;
  map<string, int> m;
  string s;

  cin >> n;
  
  while(n--) {
    cin >> s;
    m[s]++;
  }

  for (auto i = m.begin(); i != m.end(); i++) {
    ans = max(ans, i->second);
  }

  for (auto j = m.begin(); j != m.end(); j++) {
    if (ans == j->second) {
      cout << j->first;
      return 0;
    }
  }
  

  return 0;
}