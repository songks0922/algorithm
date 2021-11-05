#include <iostream>
using namespace std;

bool isPrime(int num) {
  if(num == 1) return false;
  for (int j = 2; j < num; j++) {
    if (num % j == 0) {
      return false;
    }
  }
  return true;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n, num, ans = 0;

  cin >> n;

  for (int i = 0; i < n; i++) {
    cin >> num;
    if (isPrime(num)) ans++;
  }
  cout << ans << '\n';
  return 0;
}