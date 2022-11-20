#include <iostream>

#define MAX_LENGTH 101

using namespace std;

int lcs(char a[], char b[], int m, int n);
int max(int a, int b);
int strLen(char a[]);

int memo[MAX_LENGTH][MAX_LENGTH];

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int t;

  char a[MAX_LENGTH], b[MAX_LENGTH];

  cin >> t;

  for (int i = 0; i < t; i++) {
    cin >> a >> b;

    for (int j = 0; j < strLen(a); j++) {
      for (int k = 0; k < strLen(b); k++) {
        memo[j][k] = -1;
      }
    }

    cout << lcs(a, b, strLen(a), strLen(b)) << '\n';
  }
  
  return 0;
}

int lcs(char a[], char b[], int m, int n) {
  if (m == 0 || n == 0) {
    return 0;
  }

  if (memo[m-1][n-1] != -1) {
    return memo[m-1][n-1];
  }
  
  if (a[m-1] == b[n-1]) {
    memo[m-1][n-1] = lcs(a, b, m-1, n-1) + 1;
    return memo[m-1][n-1];
  }

  memo[m-1][n-1] = max(lcs(a, b, m, n-1), lcs(a, b, m-1, n));

  return memo[m-1][n-1];
}

int max(int a, int b) {
  return a > b ? a : b;
}

int strLen(char a[]) {
  int len = 0;
  for (int i = 0; a[i] != '\0'; i++) {
    len++;
  }
  return len;
}