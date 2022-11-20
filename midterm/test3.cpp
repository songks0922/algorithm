#include <iostream>
using namespace std;

int arr[110];

bool solve(int arr[], int start, int end) {
  if (start >= end) return true;
  if (arr[start] != arr[end]) return false;
  return solve(arr, start + 1, end - 1);
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int t, n;

  cin >> t;

  for (int i = 0; i < t; i++) {
    cin >> n;
    for (int j = 0; j < n; j++) {
      cin >> arr[j];
    }

    cout << solve(arr, 0, n-1) << '\n';

  }
  
  return 0;
}