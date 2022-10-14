#include <iostream>
using namespace std;

int maxSubsequenceSum(int a[], int n, int &start, int &end);
int arr[101];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int t, n, start, end;
  cin >> t;
  for (int i = 0; i < t; i++) {
    cin >> n;
    int maxSum = 0;
    for (int j = 0; j < n; j++) {
      cin >> arr[j];
    }

    maxSum = maxSubsequenceSum(arr, n, start, end);
    cout << maxSum << " " << start << " " << end << '\n';
  }
  
  return 0;
}

int maxSubsequenceSum(int a[], int n, int &start, int &end) {
  int i, j;

  int maxSum = 0, thisSum = 0;

  start = end = -1;

  for (i = 0, j = 0; j < n; j++) {
    thisSum += a[j];

    if (thisSum > maxSum) {
      maxSum = thisSum;
      start = i;
      end = j;
      if (a[i] == 0) {
        start = ++i;
      }
    } else if (thisSum < 0){
      i = j+1;
      thisSum = 0;
    } 
  }

  return maxSum;
}