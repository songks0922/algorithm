#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  freopen("input.txt", "rt", stdin);
  char buff[100];
  int result = 0, cnt = 0;
  cin >> buff;

  for (int i = 0; buff[i] != '\0'; i++) {
    if (buff[i] >= '0' && buff[i] <= '9') {
      result = result * 10 + (buff[i] - '0');
    }
  }
  cout << result << '\n';

  for (int i = 1; i <= result; i++) {
    if (result % i == 0) cnt++;
  }
  cout << cnt;

  return 0;
}