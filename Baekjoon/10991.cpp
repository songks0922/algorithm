#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n;
  cin >> n;

  for (int i = n-1; i >= 0; i--) {
    for (int j = 0; j < i; j++) {
      cout << ' ';
    }
    cout << '*';
    
    for (int j = 0; j < (n - i - 2) * 2 + 1; j++) {
      cout << (j % 2 == 0 ? ' ' : '*');
    }
    cout << (i == n-1 ? "\n" : "*\n");
  }
  return 0;
}