#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int t, a, b;
  char temp;

  cin >> t;

  for (int i = 0; i < t; i++) {
    cin >> a >> temp >> b;

    cout << a+b << '\n';
  }

  return 0;
}