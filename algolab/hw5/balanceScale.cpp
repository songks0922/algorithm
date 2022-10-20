#include <iostream>
using namespace std;

int arr[11000];
int dp[10000100];
int balance(int arr[], int n);
int min(int a, int b);
int weight[] = {1, 2, 5, 10, 20, 50, 100};

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
    cout << balance(arr, n) << '\n';
  }
  
  return 0;
}

int balance(int arr[], int n) {
  int leftSum = 0, rightSum = 0;

  for (int i = 0; i < n; i++) {
    if (leftSum <= rightSum) leftSum += arr[i];
    else rightSum += arr[i];
  }

  int subSum = (leftSum > rightSum ? leftSum - rightSum : rightSum - leftSum);


  for (int i = 0; i < subSum + 1; i++) dp[i] = 10000000;

  dp[0] = 0;

  for (int i = 0; i < 7; i++) {
    for (int j = weight[i]; j < subSum + 1; j++)
    {
      dp[j] = min(dp[j], dp[j - weight[i]] + 1);
    }
  }

  return dp[subSum];
}

int min(int a, int b) {
  return a > b ? b : a;
}