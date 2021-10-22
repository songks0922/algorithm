#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  const int INPUT_MONEY = 1000;

  int money[6] = {500, 100, 50, 10, 5, 1};
  int n, cnt = 0;

  cin >> n;
  n = INPUT_MONEY - n;
  for (int i = 0; i < 6; i++) {
    if (n == 0) break;
    cnt += n / money[i];
    n %= money[i];
  }

  cout << cnt << '\n';

  return 0;
}