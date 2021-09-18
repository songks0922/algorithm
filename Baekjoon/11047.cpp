#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n, k, coin, cnt = 0;
  vector<int> coins;
  cin >> n >> k;

  for (int i = 0; i < n; i++) {
    cin >> coin;
    coins.push_back(coin);
  }

  while (k) {
    if (k >= coins.back()) {
      k -= coins.back();
      cnt++;
    } else {
      coins.pop_back();
    }
  }

  cout << cnt << '\n';
  return 0;
}