#include <stdio.h>
#define MAX_SIZE 1000
void insertionSort(int a[], int n);

int main() {
  int numTestCases;
  scanf("%d", &numTestCases);
  for (int i = 0; i < numTestCases; ++i) {
    int num;
    int a[MAX_SIZE];
    scanf("%d", &num);
    for (int j = 0; j < num; j++)
    scanf("%d", &a[j]);
    insertionSort(a, num);
  }
  return 0;
}

void swap(int* a, int* b) {
  int tmp = *a;
  *a = *b;
  *b = tmp;
}

/* Insertion Sort 함수 */
void insertionSort(int a[], int n) {
  int countCmpOps = 0; // 비교 연산자 실행 횟수
  int countSwaps = 0; // swap 함수 실행 횟수
  // insertion sort 알고리즘 구현
  int j;
  for (int i = 1; i < n; i++) {
    
    int temp = a[i];

    for (j = i; j > 0; j--) {
      countCmpOps++;
      if (a[j - 1] > temp) {
        a[j] = a[j - 1];
        countSwaps++;
      } else break;
    }
    a[j] = temp;

  }

  printf("%d %d\n", countCmpOps, countSwaps);
}