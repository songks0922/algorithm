#include <iostream>
#include <cstring>

using namespace std;
char a[5], b[5];

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n, res = 0;

  cin >> a >> n;

  for (int i = 0; i < n; i++) {
    cin >> b;
    if (strcmp(a, b) == 0) res++;
  }
  cout << res;
  return 0;
}