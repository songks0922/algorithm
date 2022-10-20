#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

int Rev(int n) {
  string strNum = to_string(n);
  int strlen = strNum.length();

  for(int i = 0; i < strlen / 2; i++) {
    char temp = strNum[i];
    strNum[i] = strNum[strlen - i - 1];
    strNum[strlen - i - 1] = temp;
  }
  return stoi(strNum);
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int x, y;

  cin >> x >> y;
  cout << Rev(Rev(x) + Rev(y)) << '\n';
  
  return 0;
}