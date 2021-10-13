// 거스름돈
#include <iostream>
#include <vector>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n, exchange = 0;
  vector<int> money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
  cin >> n;

  for (int i = 0; i < money.size(); i++) {
    if (n == 0) break;
    if (money[i] <= n) {
      exchange += n / money[i];
      n %= money[i];
    }
  }
  cout << exchange << '\n';
  return 0;
}