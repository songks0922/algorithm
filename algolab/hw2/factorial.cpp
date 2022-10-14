#include <iostream>

using namespace std;

int factorial(int n) {
  int temp;
  if (n <= 1) return 1;
  else {
    temp = n * factorial(n - 1);
    while(temp % 10 == 0) {
      temp /= 10;
    }
    
    temp %= 10000;
    
    return temp;
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, t;
  cin >> t;
  for (int i = 0; i < t; i++) {
    cin >> n;
    cout << factorial(n) % 1000 << '\n';
  }
  
  return 0;
}