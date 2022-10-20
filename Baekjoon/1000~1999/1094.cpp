#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  const int INIT = 64;
  int X, sum = 0, cnt = 1, divide;
  cin >> X;
  divide = INIT;
  sum = INIT;
  while (X != sum) {
    if (X == INIT) return 1;

    divide /= 2;
    cnt++;
    if (X <= sum - divide) {
      cnt--;
      sum -= divide;
    }

  }

  cout << cnt;

  return 0;
}