#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n;
  cin >> n;

  for (int i = 0; i < n; i++) {
    cout << (i % 2 == 0 ? "" : " ");
    for (int j = 0; j < n * 2 - 1; j++) {
      cout << (j % 2 == 0 ? "*" : " ");
    }
    cout << '\n';
  }
  
  return 0;
}