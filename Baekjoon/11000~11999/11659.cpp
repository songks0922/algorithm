#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int n, m, num;
  int start, end;
  cin >> n >> m;

  long dp[100001];

  for (int i = 1; i <= n; i++) {
    cin >> num;
    dp[i] = dp[i - 1] + num;
  }

  for (int i = 0; i < m; i++) {
    cin >> start >> end;

    cout << dp[end] - dp[start - 1] << '\n';
  }

  return 0;
}