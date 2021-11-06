#include <iostream>
#include <string>
#include <map>
#include <cctype>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  string word, ans = "";

  map<char, char> mapping;

  for (int i = 0; i < 26; i++) {
    mapping.insert(pair<char, char>(char('Z' - i), char('A' + i)));
  }

  getline(cin, word);

  for (char const& c : word ){
    if ((c >= 'a' && c <= 'z') || ( c >= 'A' && c <='Z')) {
      if (islower(c)) {
        ans += tolower(mapping[toupper(c)]);
      } else {
        ans += mapping[c];
      }
    }else if (c == ' ') {
      ans += ' ';
    }
  } 
  cout << ans << '\n';
  return 0;
}