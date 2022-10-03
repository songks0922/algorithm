#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int r1, s;

  cin >> r1 >> s;

  int r2;

  r2 = s * 2 - r1;

  cout << r2;
  
  return 0;
}