#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int dp[1100];

int solve(int n) {
  if (n < 2) return dp[n];

  for(int i=3; i<=n; i++)
  {
    dp[i] = (dp[i-1] + dp[i-2]) % 10007;
  }

  return dp[n];
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  dp[1] = 1; dp[2] = 2;
  
  int n; cin >> n;

  cout << solve(n);
  
  return 0;
}