#include <iostream>
using namespace std;

int fail[1001];
int strlen(char *str);
int matchCnt = 0;
void kmp(char text[], char pattern[]);
void getFail(char pattern[]);

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int t;
  char pattern[1001], text[1001];
  cin >> t;

  while (t--) {
    cin >> pattern >> text;
    kmp(text, pattern);

    for (int i = 0; i < strlen(pattern); i++) {
      cout << fail[i] << " ";
    }
    cout << '\n';
    cout << matchCnt << '\n';

    matchCnt = 0;
    for (int i = 0; i < strlen(pattern); i++) {
      fail[i] = 0;
    }
  }

  return 0;
}

int strlen(char *str) {
  int i = 0;
  while (str[i] != '\0') {
    i++;
  }
  return i;
}

void kmp(char text[], char pattern[]) {
  int i, j, txtLength, patternLength;
  txtLength = strlen(text);
  patternLength = strlen(pattern);
  getFail(pattern);

  for (i = 0, j = 0; text[i] != '\0'; i++) {
    while (j > 0 && text[i] != pattern[j]) {
      j = fail[j - 1];
    }
    if (text[i] == pattern[j]) {
      if (j == patternLength - 1) {
        matchCnt++;
        j = fail[j];
      } else {
        j++;
      }
    }
  }
}

void getFail(char pattern[]) {
  int patternLen = strlen(pattern);
  int j = 0;
  for (int i = 1; i < patternLen; i++) {
    while (j > 0 && pattern[i] != pattern[j]) {
      j = fail[j - 1];
    }
    if (pattern[i] == pattern[j]) {
      fail[i] = ++j;
    }
  }
}