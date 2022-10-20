#include <iostream>
#include <string>
using namespace std;

void swap(string& s, int a, int b) {
  char temp = s[a];
  s[a] = s[b];
  s[b] = temp;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  string s;
  int t, a, b;

  cin >> s >> t;

  for (int i = 0; i < t; i++) {
    cin >> a >> b;
    swap(s, a, b);
  }

  cout << s << '\n';
  return 0;
}