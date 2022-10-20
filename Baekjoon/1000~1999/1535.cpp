#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int a[21], b[21], dp[110];
int max(int a, int b);
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int n;

  cin >> n;

  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }  

  for (int i = 0; i < n; i++) {
    cin >> b[i];
  }

  for (int i = 0; i < n; i++) {
    for (int j = 100; j >= a[i]; j--) {
      dp[j] = max(dp[j], dp[j - a[i]] + b[i]);
    }
  }
  cout << dp[99];

  return 0;
}

int max(int a, int b) {
  return a > b ? a : b;
}