#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int compare(int a, int b) {
  if (a > b) return a;  
  return b;
}

int dp[101][100001];

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n, k, w, v;
  vector<pair<int, int>> stuffs;
  cin >> n >> k;

  pair<int, int> p = make_pair(0, 0);
  stuffs.push_back(p);

  for (int i = 0; i < n; i++) {
    cin >> w >> v;
    p = make_pair(w, v);
    stuffs.push_back(p);
  }

  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= k; j++) {
      if (j >= stuffs[i].first) {
        dp[i][j] = compare(dp[i-1][j], dp[i-1][j-stuffs[i].first] + stuffs[i].second);
      } else {
        dp[i][j] = dp[i-1][j];
      }
    }
  }
  cout << dp[n][k] << '\n';
  return 0;
}