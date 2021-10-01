#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

bool cmp(string a, string b) {
  for (int i = 0; i < a.length(); i++) {
    a[i] = toupper(a[i]);
  }
  for (int i = 0; i < b.length(); i++) {
    b[i] = toupper(b[i]);
  }
  return a < b;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n;
  string word;
  vector<string> words;

  while (1) {
    cin >> n;
    if (n == 0) break;
    for (int i = 0; i < n; i++) {
      cin >> word;
      words.push_back(word);
    }
    sort(words.begin(), words.end(), cmp);
    cout << words[0] << '\n';
    words.clear();
  }

  return 0;
}