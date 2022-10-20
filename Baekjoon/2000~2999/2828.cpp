#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n, m, j, apple, cnt = 0;
  cin >> n >> m >> j;

  int basketIdx = 1;

  for (int i = 0; i < j; i++) {
    cin >> apple;
    int right = basketIdx + m - 1;
    if (apple >= basketIdx && apple <= right) {
      continue;
    } else if (apple < basketIdx) {
      cnt += basketIdx - apple;
      basketIdx -= basketIdx - apple;
    } else {
      cnt += apple - right;
      basketIdx += apple - right;
    }
  }

  cout << cnt << '\n';
  return 0;
}