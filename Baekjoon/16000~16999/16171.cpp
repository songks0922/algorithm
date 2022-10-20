#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  string s, k;
  string temp;

  char ch;
  char* ptr = &ch;
  
  cin >> s >> k;
  for (int i = 0; i < s.length(); i++) {
    ch = s[i];
    if (atoi(ptr) == 0 && ch != '0') {
      temp += s[i];
    }
  }
  cout << (temp.find(k) != string::npos ? "1" : "0") << '\n';

  return 0;
}