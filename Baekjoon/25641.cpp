#include <iostream>
using namespace std;

char str[101];

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int n, i, s = 0, t = 0;

  cin >> n >> str;

  for (i = 0; str[i] != '\0'; i++) {
    if (str[i] == 's') s++;
    else t++;
  }

  i = 0;

  while (t != s) {
    if (str[i] == 's') s--;
    else t--;
    i++;
  }

  cout << &str[i];
  
  return 0;
}