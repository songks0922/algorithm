#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n, sum = 0;

  for (int i = 0; i < 5; i++) {
    cin >> n;
    sum += (n > 40 ? n : 40);
  }

  cout << sum / 5;
  return 0;
}