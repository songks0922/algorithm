#include <iostream>
using namespace std;

int arr[110];
int cnt = 0;

int solve(int arr[], int start, int end) {
  if (start == end) {
    cnt++;
    return arr[start];
  }

  int mid = (start + end) / 2;
  int left = solve(arr, start, mid);
  int right = solve(arr, mid + 1, end);

  return left > right ? left : right;
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
    cout << cnt;
    cnt = 0;
  }
  
  return 0;
}