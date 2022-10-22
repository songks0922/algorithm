#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

string dp[255];

string add(string a, string b) {
  string result = "";
  int sum = 0;
  while (!a.empty() || !b.empty() || sum) {
    if (!a.empty()) {
        sum += a.back() - '0';
        a.pop_back();
    }
    if (!b.empty()) {
        sum += b.back() - '0';
        b.pop_back();
    }
    result.push_back((sum % 10) + '0');
    sum /= 10;
  }
  reverse(result.begin(), result.end());
  return result;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  dp[0] = "1";
  dp[1] = "1";
  dp[2] = "3";

  int n;

  for (int i = 3; i <= 250; i++) {
    dp[i] = add(add(dp[i - 2], dp[i - 2]), dp[i - 1]);
  }

  while (cin >> n) {
    cout << dp[n] << '\n';
  }

  return 0;
}