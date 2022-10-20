#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int a, b, c;

  while (cin >> a >> b >> c) {
    int d = (b - a) < (c - b) ? (c - b - 1) : (b - a - 1);
    cout << d << '\n';
  }
  return 0;
}