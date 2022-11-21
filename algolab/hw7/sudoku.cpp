#include <bits/stdc++.h>

#include <iostream>

using namespace std;

#define N 4

int **arr;
void clear(int **arr);
bool isPromising(int x, int y, int num);
void printSudoku();
bool sudoku(int x, int y);

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int t;
  cin >> t;

  arr = new int *[N];

  while (t--) {
    for (int i = 0; i < N; i++) {
      arr[i] = new int[N];
      for (int j = 0; j < N; j++) {
        cin >> arr[i][j];
      }
    }

    sudoku(0, 0);
    printSudoku();
    clear(arr);
  }

  return 0;
}

bool sudoku(int row, int col) {
  if (row >= N && col >= N - 1) {
    return true;
  }

  if (row == N) {
    col += 1;
    row = 0;
  }

  if (arr[row][col] > 0) {
    return sudoku(row + 1, col);
  }

  for (int i = 1; i <= N; i++) {
    if (isPromising(row, col, i)) {
      arr[row][col] = i;

      if (sudoku(row + 1, col)) {
        return true;
      }
      arr[row][col] = 0;
    }
  }

  return false;
}

void printSudoku() {
  for (int i = 0; i < N; i++) {
    for (int j = 0; j < N; j++) {
      cout << arr[i][j] << " ";
    }
    cout << endl;
  }
}

bool isPromising(int x, int y, int num) {
  for (int i = 0; i < N; i++) {
    if (arr[x][i] == num) {
      return false;
    }
  }

  for (int i = 0; i < N; i++) {
    if (arr[i][y] == num) {
      return false;
    }
  }
  int pivot = sqrt(N);
  int startRow = x - x % pivot;
  int startCol = y - y % pivot;

  for (int row = 0; row < pivot; row++) {
    for (int col = 0; col < pivot; col++) {
      if (arr[row + startRow][col + startCol] == num) {
        return false;
      }
    }
  }
  return true;
}

void clear(int **arr) {
  for (int i = 0; i < N; i++) {
    for (int j = 0; j < N; j++) {
      arr[i][j] = 0;
    }
  }
}