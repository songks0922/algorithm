#include <iostream>

#define MAX_LENGTH 11

using namespace std;

int lcs(char a[], char b[], int m, int n);
int max(int a, int b);
int strLen(char a[]);

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int t;

  char a[MAX_LENGTH], b[MAX_LENGTH];

  cin >> t;

  for (int i = 0; i < t; i++) {
    cin >> a >> b;

    cout << lcs(a, b, strLen(a), strLen(b)) << '\n';
  }
  
  return 0;
}

int lcs(char a[], char b[], int m, int n) {
  if (m == 0 || n == 0) {
    return 0;
  }
  
  if (a[m-1] == b[n-1]) {
    return lcs(a, b, m-1, n-1) + 1;
  }

  return max(lcs(a, b, m, n-1), lcs(a, b, m-1, n));
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