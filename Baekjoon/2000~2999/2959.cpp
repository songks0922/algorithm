#include <iostream>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int num[4];

  for (int i = 0; i < 4; i++) {
    cin >> num[i];
  }

  sort(num, num + 4);

  cout << num[0] * num[2] << '\n';
  return 0;
}