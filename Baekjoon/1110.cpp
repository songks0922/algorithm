#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n, ans = 1;

  cin >> n;

  int newNum = (n / 10 + n % 10) % 10 + ((n%10) * 10);
  while (n != newNum) {
    newNum = (newNum / 10 + newNum % 10) % 10 + ((newNum%10) * 10);
    ans++;
  }
  cout << ans << '\n';
  return 0;
}