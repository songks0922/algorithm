#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  char r1[101], r2[101];
  int r, c, a, b;

  cin >> r >> c >> a >> b;

  for (int i = 0; i < c; i++) {
    if (i % 2 == 0) {
      for (int j = i; j < i+r; j++) {
        r1[j] = 'X';
      }
    } else {
      for (int j = i; j < i+r; j++) {
        r1[j] = '.';
      }
    }
  }

  cout << r1;
  return 0;
}