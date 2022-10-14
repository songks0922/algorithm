#include <iostream>
#include <vector>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n, k, i, sum = 0, max;

  cin >> n >> k;

  vector<int> v(n);

  for (int i = 0; i < n; i++) {
    cin >> v[i];
  }

  for (int i = 0; i < k; i++) {
    sum += v[i];
  }

  max = sum;

  for (int i = k; i < n; i++) {
    sum = sum + (v[i] - v[i-k]);
    if (sum > max) max = sum;
  }

  cout << sum << '\n';
  
  return 0;
}