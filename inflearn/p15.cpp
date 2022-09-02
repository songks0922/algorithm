#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  freopen("input.txt", "rt", stdin);

  int n, flag, cnt = 0;

  cin >> n;

  for (int i = 2; i <= n; i++) {
    flag = 1;
    for (int j = 2; j*j <= i; j++) {
      if (i % j == 0) {
        flag = 0;
        break;
      }
    }

    if (flag == 1) cnt++;
  }

  cout << cnt << '\n';

  return 0;
}