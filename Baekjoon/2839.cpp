#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n;
  int ans = 0;
  cin >> n;
  
  while (n > 0) {
    if (n % 5 == 0) {
      ans += n/5;
      n %= 5;
    } else {
      n -= 3;
      ans++;
    }
  }

  cout << (n == 0 ? ans : -1) << '\n';

  return 0;
}