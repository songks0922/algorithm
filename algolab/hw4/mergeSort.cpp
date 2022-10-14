#include <iostream>
using namespace std;

int arr[110];
int count = 0;
int merge(int arr[], int low, int mid, int high);
void mergeSort(int arr[], int low, int high);

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
    mergeSort(arr, 0, n-1);
    cout << count << '\n';
    count = 0;
  }
  
  return 0;
}

void mergeSort(int arr[], int low, int high) {
  int mid = (low + high) / 2;

  if (low == high) return;

  mergeSort(arr, low, mid);
  mergeSort(arr, mid+1, high);
  merge(arr, low, mid, high);
  
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