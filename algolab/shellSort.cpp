#include <stdio.h>
#define MAX_SIZE 1000
void ShellSort(int a[], int n);
int main() {
  int numTestCases;
  scanf("%d", &numTestCases);
  for (int i = 0; i < numTestCases; ++i) {
    int num;
    int a[MAX_SIZE];

    scanf("%d", &num);

    for (int j = 0; j < num; j++)
      scanf("%d", &a[j]);
    ShellSort(a, num);
  }
  return 0;
}

void swap(int* a, int* b) {
  int tmp = *a;
  *a = *b;
  *b = tmp;
}
/* Shell Sort 함수 */
void ShellSort(int a[], int n) {
  int countCmpOps = 0; // 비교 연산자 실행 횟수
  int countSwaps = 0; // swap 함수 실행 횟수
  // Shell sort 알고리즘 구현

  const int SHRINK_RATIO = 2;
  int gap = n / SHRINK_RATIO, j;

  while (gap > 0) {
    for (int i = 0; i < n; i++) {
      int temp = a[i];
      for (j = i; j >= gap; j -= gap) {
        countCmpOps++;
        if (a[j - gap] > temp) {
          a[j] = a[j - gap];
          countSwaps++;
        } else break;
      }
      a[j] = temp;
    }
    gap /= SHRINK_RATIO;
  }

  printf("%d %d\n", countCmpOps, countSwaps);
}