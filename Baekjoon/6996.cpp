#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n;
  string s1, s2;
  vector<char> chars;
  cin >> n;

  for (int i = 0; i < n; i++) {
    cin >> s1 >> s2;
    
    for (int j = 0; j < s2.length(); j++) {
      chars.push_back(s2[j]);
    }

    for (int j = 0; j < s1.length(); j++) {
      auto it = find(chars.begin(), chars.end(), s1[j]);
      if(it != chars.end()) {
        chars.erase(it);
      }
    }
    cout << s1 << " & " << s2 << " are " << (chars.size() == 0 && s1.length() == s2.length() ? "anagrams." : "NOT anagrams.") << '\n';
    chars.clear();
  }
  return 0;
}