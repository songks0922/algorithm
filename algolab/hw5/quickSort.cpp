#include <iostream>
using namespace std;

void quickSortHoare(int v[], int low, int high, int* swapCnt, int *compCnt);
int partitionHoare(int a[], int low, int high, int *swapCnt, int *compCnt);

void quickSortLomuto(int v[], int low, int high, int *swapCnt, int *compCnt);
int partitionLomuto(int a[], int low, int high, int *swapCnt, int *compCnt);
void swap(int *a, int *b);

int* copyArray(int arr[], int n);

int arr[1010];
int temp1 = 0, temp2 = 0;
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

    int swapCntL = 0, compCntL = 0, swapCntH = 0, compCntH = 0;
    int *temp = copyArray(arr, n); 
    quickSortLomuto(temp, 0, n-1, &swapCntL, &compCntL);

    temp = copyArray(arr, n);
    quickSortHoare(temp, 0, n-1, &swapCntH, &compCntH);
    cout << swapCntH << " " << swapCntL << " " << compCntH << " " << compCntL << '\n';
  }
  
  
  return 0;
}

int partitionLomuto(int a[], int low, int high, int *swapCnt, int *compCnt) {
  int i, j;
  int pivot, pivotPos, tmp;
  pivot = a[low];
  j = low;
  for(i=low+1; i<=high; i++) {
    
    *compCnt += 1;
    if(a[i] < pivot) {
      j++;

      *swapCnt += 1;
      swap(a[i], a[j]);
    }
  }
  pivotPos= j;

  swap(a[low], a[pivotPos]);
  *swapCnt += 1;
  
  return pivotPos;
}

void quickSortLomuto(int v[], int low, int high, int* swapCnt, int *compCnt) {
  int pivotPos;
  if (high > low) {
    pivotPos= partitionLomuto(v, low, high, swapCnt, compCnt);
    quickSortLomuto(v, low, pivotPos - 1, swapCnt, compCnt);
    quickSortLomuto(v, pivotPos +1, high, swapCnt, compCnt);
  }
}

void quickSortHoare(int v[], int low, int high, int* swapCnt, int *compCnt) {
  int pivotPos;
  if (high > low) {
    pivotPos= partitionHoare(v, low, high, swapCnt, compCnt);
    quickSortHoare(v, low, pivotPos, swapCnt, compCnt);
    quickSortHoare(v, pivotPos + 1, high, swapCnt, compCnt);
  }
}

int partitionHoare(int a[], int low, int high, int *swapCnt, int *compCnt) {
  int i, j;
  int pivot;
  pivot = a[low];
  i= low - 1;
  j = high + 1;
  while (true) {
    do
    {
      i++;
      *compCnt += 1;
    } while (a[i] < pivot);

    do
    {
      j--;
      *compCnt += 1;
    } while (a[j] > pivot);

    if (i < j)
    {
      swap(a[i], a[j]);
      *swapCnt += 1;
    }
    else
      return j;
  }
  
}

void swap(int *a, int *b) {
  int temp = *a;
  *a = *b;
  *b = temp;
}

int* copyArray(int arr[], int n) {
  int *temp = new int[n+10];

  for (int i = 0; i < n; i++) {
    temp[i] = arr[i];
  }
  return temp;
}