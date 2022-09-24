#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  char num[5];

  while(cin >> num) {
    if (num[0] == '0') break;
    int empty = 2;
    for (int i = 0; num[i] != '\0'; i++) {
      if (num[i] == '1') empty += 2;
      else if (num[i] == '0') empty += 4;
      else empty += 3;
      empty++;
    }
    cout << --empty << '\n';
  }
  return 0;
}