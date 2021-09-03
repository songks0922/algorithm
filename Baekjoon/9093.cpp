#include <iostream>
#include <vector>
#include <string>
#include<sstream>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int T;
  string line;
  cin >> T;
  
  getline(cin, line);
  for(int i = 0; i < T; i++) {
    getline(cin, line);
    istringstream ss(line);
    string buffer;

    while(getline(ss, buffer, ' ')) {
      // ' ' 문자가 나올 때까지 읽음
      int len = buffer.length();
      for (int i = len-1; i >= 0; i--) {
        cout << buffer[i];
      }
      cout << " ";
    }
    cout << '\n';
  }
  
  return 0;
}