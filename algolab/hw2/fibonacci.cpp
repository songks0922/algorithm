#include <iostream>

using namespace std;

int fib(int n);

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int t, n;

  cin >> t;

  for (int i = 0; i < t; i++) {
    cin >> n;
    cout << fib(n) << '\n';
  }
  
  return 0;
}

int fib(int n) {
  if (n <= 1) return n;
  else return fib(n - 1) + fib(n-2);
}