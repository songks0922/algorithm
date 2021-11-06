#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int num, ans = 0;

  cin >> num;
  
  for (int i  = 3; i <= num; i++) {
    string numString = to_string(i);
    for (char const& c : numString) {
      if (c == '3' || c == '6' || c == '9') {
        ans++;
      }
    }
  }

  cout << ans << '\n';
  return 0;
}