#include <iostream>
using namespace std;

int gcd(int a, int b);

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int t, a, b;

  cin >> t;

  for (int i = 0; i < t; i++) {
    cin >> a >> b;
    cout << gcd(a, b) << '\n';
  }
  
  return 0;
}

int gcd(int a, int b) {
  if (b == 0) return a;
  else return gcd(b, a%b);
}