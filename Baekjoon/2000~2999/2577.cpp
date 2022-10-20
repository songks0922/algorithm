#include <iostream>
#include <string>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int a, b, c;
  int ans[10] = {0, };
  cin >> a >> b >> c;

  int result = a * b * c;
  string s = to_string(result);

  for (int i = 0; i < s.length(); i++) {
    ans[s[i] - '0']++;
  }

  for (int i = 0; i < 10; i++) {
    cout << ans[i] << '\n';
  }

  return 0;
}