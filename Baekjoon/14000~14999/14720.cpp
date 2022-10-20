#include <iostream>
#include <vector>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n, milk;
  int ans = 0, idx = 0;
  
  vector<int> milks;

  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> milk;
    milks.push_back(milk);
  }

  for (int i = 0; i < milks.size(); i++) {
    if (idx > 2) {
      idx = 0;
    }
    if (milks[i] == idx) {
      ans++;
      idx++;
    }
  }

  cout << ans << '\n';
  return 0;
}