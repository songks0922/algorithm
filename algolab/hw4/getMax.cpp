#include <iostream>
using namespace std;

int max(int a, int b);
int recurMax(int arr[], int left, int right);
int arr[101];

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

    cout << recurMax(arr, 0, n-1) << '\n';
  }

  
  return 0;
}

int recurMax(int arr[], int left, int right) {
  int half;

  if (left == right) {
    return arr[right];
  }
  half = (left + right) / 2;

  return max(recurMax(arr, left, half), recurMax(arr, half+1, right));
}

int max(int a, int b) {
  return a > b ? a : b;
}