#include <iostream>
using namespace std;

int coins[5];
int dp[25];

int min(int a, int b) {
  return a > b ? b : a;
}


int solve(int n, int coins[], int cnt) {
  if (dp[n] != 0) return dp[n];
  for (int i = 0; i < cnt; i++) {
    if (n - coins[i] >= 0) {
      dp[n] = min(dp[n], solve(n - coins[i], coins, cnt) + 1);
    }
  }
  return dp[n];
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int t, k, n;

  dp[0] = 0;
  // for (int i = 1; i < 21; i++) {
  //   dp[i] = -1;
  // }

  cin >> t;
  
  for (int i = 0; i < t; i++) {
    cin >> k >> n;

    for (int j = 0; j < n; j++) {
      cin >> coins[j];
    }
    cout << solve(k, coins, n) << '\n';
  }
  
  return 0;
}