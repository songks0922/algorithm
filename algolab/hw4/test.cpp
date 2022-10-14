#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int max(int a, int b) {
  return (a > b ? a : b);
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int a = -2147483648;
  int ans = max(11, 10);
  ans = max(ans, 3);
  cout << ans;
  return 0;
}