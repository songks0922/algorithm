#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int t;
  int time[3] = {300, 60, 10};
  int ans[3] = {0, };
  cin >> t;

  for (int i = 0; i < 3; i++) {
    if (t % 10 != 0) break;
    if (t == 0) break;
    if (time[i] <= t) {
      ans[i] += t / time[i];
      t %= time[i];
    }
  }


  if (t != 0) {
    cout << "-1" << '\n';
  } else {
    for (int i = 0; i < 3; i++) {
      cout << ans[i] << " ";
    }
    cout << '\n';
  }
  
  return 0;
}