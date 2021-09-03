#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  string word;
  cin >> word;

  for (int i = 0; i < word.length(); i++) {
    if (int('A') <= int(word[i]) && int('Z') >= int(word[i])) {
      cout << char(tolower(word[i]));
    } else {
      cout << char(toupper(word[i]));
    }
  }
  return 0;
}