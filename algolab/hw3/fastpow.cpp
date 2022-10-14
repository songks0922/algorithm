#include <iostream>
using namespace std;

int pow(int x, int n) {
  int y;

  if (n == 0) return 1;

  if (n % 2 == 1) {
    y = pow(x, (n-1)/2);
    return (x*y*y) % 1000;
  }
  
  y = pow(x, n/2);
  return (y*y) % 1000;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int t, a, n;

  cin >> t;

  for (int i = 0; i < t; i++) {
    cin >> a >> n;
    cout << pow(a, n) << '\n';
  }
  
  return 0;
}