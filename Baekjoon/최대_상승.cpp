#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int n, num, max_ = -1, ans = 0;
  vector<int> v;

  cin >> n;

  for (int i = 0; i < n; i++) {
    cin >> num;
    v.push_back(num);
  }

  for (int i = v.size()-1; i>=0; i--) {
    if (v[i] > max_) max_ = v[i];
    ans = max(ans, max_ - v[i]);
  }

  cout << ans;
  
  return 0;
}