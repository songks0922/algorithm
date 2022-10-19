#include <iostream>
#include <string>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n, sum = 0;
  string str;

  cin >> n >> str;

  for (int i = 0; i < str.size(); i++) {
    sum += str[i] - '0';
  }

  cout << sum;

  return 0;
}