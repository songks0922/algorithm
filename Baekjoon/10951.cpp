#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int a, b;
  while(cin >> a >> b) {
    cout << a + b << '\n';
  }
  return 0;
}