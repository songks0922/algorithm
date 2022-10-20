#include <iostream>
using namespace std;

bool checkPalindrome(char str[], int first, int last);
int strlen(char str[]);

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  char str[6];

  while(cin >> str) {
    if (str[0] == '0') return 0;

    if (checkPalindrome(str, 0, strlen(str) - 1)) cout << "yes\n";
    else cout << "no\n";
  }
  
  return 0;
}

int strlen(char str[]) {
  int len = 0;
  for (int i = 0; str[i] != '\0'; i++) len++;
  return len;
}

bool checkPalindrome(char str[], int first, int last) {
  if (last <= first) return true;
  else if (str[first] != str[last]) return false;
  else return checkPalindrome(str, first+1, last-1);
}