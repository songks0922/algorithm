#include <iostream>
using namespace std;

int arr[110];
int count = 0;
int merge(int arr[], int low, int mid, int high);
void mergeSortIterative(int v[], int n);
int min(int a, int b);

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
    mergeSortIterative(arr, n);
    cout << count << '\n';
    count = 0;
  }
  
  return 0;
}

void mergeSortIterative(int v[], int n) {
  int size = 1;
  while (size < n) {
    for (int i = 0; i < n; i += 2 * size) {
      int low = i;
      int mid = low + size -1;
      int high = min(i+ 2 * size -1, n -1);

      if (mid >= n -1) break;
      merge(v, low, mid, high);
    }

    size *= 2;

  }
}

int merge(int arr[], int low, int mid, int high) {
  int temp[110];

  int i, j, k;

  for (i = low; i <= high; i++) {
    temp[i] = arr[i];
  }

  i = k = low;
  j = mid + 1;

  while (i <= mid && j <= high) {
    count++;
    if (temp[i] <= temp[j]) {
      arr[k++] = temp[i++];
    } else {
      arr[k++] = temp[j++];
    }
  }

  while (i <= mid) {
    arr[k++] = temp[i++];
  }

  while (j <= high) {
    arr[k++] = temp[j++];
  }
}

int min(int a, int b) {
  return a > b ? b : a;
}