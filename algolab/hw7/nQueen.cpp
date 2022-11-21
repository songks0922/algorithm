#include <iostream>

using namespace std;

void nQueens(int row);
void printNqueens();
int isPromising(int row);

int n;
int col[16];
int flag;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int t;
  cin >> t;

  for (int i = 0; i < t; i++) {
    cin >> n;

    flag = 0;

    for (int j = 0; j < n; j++) {
      col[0] = j;
      nQueens(0);
    }
  }

  return 0;
}

int isPromising(int row) {
  int k;
  int promising;
  k = 0;
  promising = 1;
  while (k < row && promising) {
    if (col[row] == col[k] || abs(col[row] - col[k]) == row - k) {
      promising = 0;
    }
    k++;
  }
  return promising;
}

void nQueens(int row) {
  int i;
  if (isPromising(row))
    if (row == n - 1) {
      flag = 1;
      printNqueens();
    } else
      for (i = 0; i < n; i++) {
        col[row + 1] = i;
        if (flag != 1) {
          nQueens(row + 1);
        }
      }
}

void printNqueens() {
  for (int i = 0; i < n; i++) cout << col[i] + 1 << " ";
  cout << endl;
}