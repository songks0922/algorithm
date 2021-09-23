#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n;
  cin >> n;

  for (int i = 0; i < n; i++) {
    for (int j = 0; j <= i; j++) {
      cout << '*';
    }
    cout << '\n';
  }

  for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - 1 - i; j++) {
      cout << '*';
    }
    cout << '\n';
  }
  return 0;
}