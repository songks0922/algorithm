#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


int dp[2][100010];
int arr[100010];

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int n; cin >> n;
  int maxLen = 0;

  if (n == 1) {
    cout << 1;
    return 0;
  }

  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    dp[0][i] = 1; dp[1][i] = 1;

    if (i > 0) {
      if (arr[i - 1] <= arr[i]) {
        dp[0][i] = dp[0][i-1] + 1; 
      }
      if (arr[i - 1] >= arr[i]) {
        dp[1][i] = dp[1][i-1] + 1;
      }

      maxLen = max(maxLen, max(dp[0][i], dp[1][i]));
    }
  }

  cout << maxLen;

  return 0;
}