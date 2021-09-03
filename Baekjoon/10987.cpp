#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  string word;
  int cnt = 0;
  cin >> word;
  for (int i = 0; i < word.length(); i++) {
    if (word[i] == 'a' || word[i] == 'e' || word[i] == 'i' || word[i] == 'o' || word[i] == 'u') cnt++;
  }
  cout << cnt << '\n';
  return 0;
}