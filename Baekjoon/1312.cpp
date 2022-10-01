#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int a, b, n;
  int answer = 0;
  cin >> a >> b >> n;

  if (a % b == 0) {
    cout << 0;
    return 0;
  }

  a = a % b;

  for (int i = 0; i < n; i++) {
    a *= 10;
    answer = (int)(a/b);
    a %= b;
  }
  cout << answer;
  return 0;
}