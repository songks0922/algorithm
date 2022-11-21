#include <bits/stdc++.h>
using namespace std;

//   [NxN] SUDOKU SOLVER

// This function ckecks for the valid case is a number
// can be placed in the given block
bool issafe(int** arr, int x, int y, int N, int num) {
  int row, col;

  for (row = 0; row < N; row++) {
    if (arr[row][y] == num) {
      return false;
    }
  }

  for (col = 0; col < N; col++) {
    if (arr[x][col] == num) {
      return false;
    }
  }

  int z = sqrt(N);
  int start_row = x - x % z;
  int start_col = y - y % z;

  for (row = 0; row < z; row++) {
    for (col = 0; col < z; col++) {
      if (arr[row + start_row][col + start_col] == num) {
        return false;
      }
    }
  }
  return true;
}

bool sudoku(int** arr, int N, int row, int col) {
  if (row >= N && col >= N - 1) {
    return true;
  }

  if (row == N) {
    col += 1;
    row = 0;
  }

  if (arr[row][col] > 0) {
    return sudoku(arr, N, row + 1, col);
  }

  for (int i = 1; i <= N; i++) {
    if (issafe(arr, row, col, N, i)) {
      arr[row][col] = i;

      if (sudoku(arr, N, row + 1, col)) {
        return true;
      }
      arr[row][col] = 0;
    }
  }

  return false;
}

int main() {
  int N;
  cin >> N;

  int** arr = new int*[N];

  for (int i = 0; i < N; i++) {
    arr[i] = new int[N];

    for (int j = 0; j < N; j++) {
      cin >> arr[i][j];
    }
  }

  if (sudoku(arr, N, 0, 0)) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        cout << arr[i][j] << " ";
      }
      cout << endl;
    }
  }

  return 0;
}