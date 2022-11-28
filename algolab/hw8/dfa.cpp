#include <iostream>
using namespace std;
#define R 3
#define MAX_SIZE 1001

int DFA[R][MAX_SIZE];
void constructDFA(char pattern[]);
void sovleDFA(char text[]);
int strlen(char *str);
int patternLen = 0, zeroCnt = 0, matchCnt = 0;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int T;
  cin >> T;

  while (T--) {
    char pattern[1001];
    cin >> pattern;
    patternLen = strlen(pattern);
    constructDFA(pattern);
    char text[1001];
    cin >> text;

    sovleDFA(text);
    for (int i = 0; i < R; i++) {
      for (int j = 0; j <= patternLen; j++) {
        if (DFA[i][j] != 0) {
          zeroCnt++;
        }
      }
    }
    cout << zeroCnt << " " << matchCnt << endl;
    zeroCnt = 0;
    matchCnt = 0;

    for (int i = 0; i < R; i++) {
      for (int j = 0; j <= patternLen; j++) {
        DFA[i][j] = 0;
      }
    }
  }

  return 0;
}

void sovleDFA(char text[]) {
  int i, j, txtLength;
  txtLength = strlen(text);
  for (i = 0, j = 0; text[i] != '\0'; i++) {
    j = DFA[text[i] - 'A'][j];
    if (j == patternLen) {
      matchCnt++;
    }
  }
}

void constructDFA(char pattern[]) {
  int M = strlen(pattern);
  int X = 0;
  DFA[pattern[0] - 'A'][0] = 1;

  for (int j = 1; j < M; j++) {
    for (int c = 0; c < R; c++) {
      DFA[c][j] = DFA[c][X];
    }
    DFA[pattern[j] - 'A'][j] = j + 1;
    X = DFA[pattern[j] - 'A'][X];
  }

  for (int c = 0; c < R; c++) {
    DFA[c][M] = DFA[c][X];
  }
}

int strlen(char *str) {
  int i = 0;
  while (str[i] != '\0') i++;
  return i;
}