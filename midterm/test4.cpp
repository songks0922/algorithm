#include <iostream>
using namespace std;

int dp[110][110];

int solve(int n, int k) {
  if (k == 0 || k == n) return 1;
  if (dp[n][k] != 0) return dp[n][k];
  return dp[n][k] = (solve(n-1, k-1) + solve(n-1, k)) % 1000;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int t, n, k;

  cin >> t;

  for (int i = 0; i < t; i++) {
    cin >> n >> k;
    cout << solve(n, k) << '\n';
  }
  
  return 0;
}