//카이사르 암호 복호화 문제
#include <iostream>
#include <string>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  string caesar;
  cin >> caesar;
  for (int i = 0; i < caesar.length(); i++) {
    if(caesar[i] - 3 < 'A') {
      caesar[i] = caesar[i] - 2 + ('Z' - 'A');
    } else {
      caesar[i] = caesar[i] - 3;
    }
  }
  cout << caesar << '\n';
  return 0;
}