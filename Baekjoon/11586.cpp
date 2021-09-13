#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n, k;
  string s;
  vector<string> mirror;

  cin >> n;
  
  for(int i = 0; i < n; i++) {
    cin >> s;
    mirror.push_back(s);
  }

  cin >> k;

  if (k == 1) {
    for(int i = 0; i < n; i++) {
      cout << mirror[i] << '\n';
    }
  } else if (k == 2) {
    for(int i = 0; i < n; i++) {
      for (int j = n-1; j >= 0; j--) {
        cout << mirror[i][j];
      }
      cout << '\n';
    }
  } else {
    for(int i = n-1; i >= 0; i--) {
      cout << mirror[i] << '\n';
    }
  }
  
  return 0;
}