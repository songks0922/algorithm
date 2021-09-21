#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n;
  cin >> n;

  for (int i = n; i > 0; i--) {
    for (int j = 1; j < n - i + 1; j++) {
      cout << ' ';
    }
    for (int j = 0; j <= 2 * i - 2; j++) {
      cout << '*';
    }
    cout << '\n';
  }

  for (int i = n-1; i > 0; i--) {
    for (int j = 1; j < i; j++) {
      cout << ' ';
    }
    for (int j = 0; j < (n - i) * 2 + 1; j++) {
      cout << '*';
    }
    cout << '\n';
  }
  
  return 0;
}