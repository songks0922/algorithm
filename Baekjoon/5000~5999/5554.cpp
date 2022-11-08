#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int t, sum = 0;

  for (int i = 0; i < 4; i++) {
    cin >> t;
    sum += t;
  }

  cout << sum / 60 << '\n';
  sum -= (sum / 60) * 60;
  cout << sum;

  return 0;
}