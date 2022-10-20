#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

bool cmp(string s1, string s2) {
  if (s1.length() > s2.length()) {
    return false;
  } else if (s1.length() == s2.length()) {
    return s1 < s2;
  }
  return true;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n;
  vector<string> v;
  string s;
  cin >> n;

  for (int i = 0; i < n; i++) {
    cin >> s;
    v.push_back(s);
  }

  sort(v.begin(), v.end(), cmp);

  v.erase(unique(v.begin(), v.end()), v.end());

  for (int i = 0; i < v.size(); i++) {
    cout << v[i] << '\n';
  }
  return 0;
}