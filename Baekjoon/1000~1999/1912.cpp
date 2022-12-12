#include <algorithm>
#include <iostream>
#include <vector>

#define MAX 100000
using namespace std;

int max(int a, int b);

int dp[MAX + 1];
int num[MAX + 1];

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int n, sumMax;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> num[i];
  }

  dp[1] = num[1];
  sumMax = num[1];

  for (int i = 2; i <= n; i++) {
    dp[i] = max(dp[i - 1] + num[i], num[i]);
    sumMax = max(dp[i], sumMax);
  }

  cout << sumMax << '\n';

  return 0;
}

int max(int a, int b) { return a > b ? a : b; }