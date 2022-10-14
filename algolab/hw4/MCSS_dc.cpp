#include <iostream>
using namespace std;

int arr[110];
int max(int a, int b);
int maxSubsequenceSum(int arr[], int start, int end);
int crossSubsequenceSum(int arr[], int start, int end, int half);

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

    cout << maxSubsequenceSum(arr, 0, n-1) << "\n";
  }
  
  return 0;
}

int max(int a, int b) {
  return (a > b ? a : b);
}

int maxSubsequenceSum(int arr[], int start, int end) {
  if (end == start) return arr[end];

  int half = (start + end ) / 2;

  int leftSum = maxSubsequenceSum(arr, start, half);
  int rightSum = maxSubsequenceSum(arr, half + 1, end);
  int crossSum = crossSubsequenceSum(arr, start, end, half);

  int ans = max(leftSum, rightSum);
  ans = max(ans, crossSum);

  return ans <= 0 ? 0 : ans;
}

int crossSubsequenceSum(int arr[], int start, int end, int half) {
  int sum = 0;
  int leftSum, rightSum;

  leftSum = rightSum = -2147483648;

  for (int i = half; i >= start; i--) {
    sum += arr[i];
    if (sum > leftSum) leftSum = sum;
  }

  sum = 0;

  for (int i = half + 1; i <= end; i++) {
    sum += arr[i];
    if (sum > rightSum) rightSum = sum;
  }

  return leftSum + rightSum;
}