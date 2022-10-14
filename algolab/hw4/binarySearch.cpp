#include <iostream>

using namespace std;

int arr[101];
int binarySearch(int arr[], int left, int right, int value);

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int t, n, val;

  cin >> t;

  for (int i = 0; i < t; i++) {
    cin >> n >> val;
    for (int j = 0; j < n; j++) {
      cin >> arr[j];
    }
    cout << binarySearch(arr, 0, n-1, val) << '\n';
  }
  
  return 0;
}

int binarySearch(int arr[], int left, int right, int value) {
  int mid;

  if (left > right) {
    return -1;
  }

  mid = (left + right) / 2;

  if (arr[mid] == value) return mid;
  else if (arr[mid] > value) return binarySearch(arr, left, mid-1, value);
  return binarySearch(arr, mid+1, right, value);
}