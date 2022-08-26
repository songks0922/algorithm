#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n, sum = 0, digit = 9, cnt = 1, res = 0;

  cin >> n;

  while (sum+digit < n) {
    res += (cnt * digit);
    sum += digit;
    cnt++;
    digit *= 10;
  }

  res = res + ((n - sum) * cnt);
  cout << res;
  return 0;
}