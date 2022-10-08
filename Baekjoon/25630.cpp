#include <iostream>
using namespace std;

int checkPalindrome(char str[], int first, int last);

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n;
  char str[101];

  cin >> n >> str;
  cout << checkPalindrome(str, 0, n-1);
  
  return 0;
}

int checkPalindrome(char str[], int first, int last) {
  if (last <= first) return 0;
  else if (str[first] != str[last]) return 1 + checkPalindrome(str, first+1, last-1);
  else return checkPalindrome(str, first+1, last-1);
}