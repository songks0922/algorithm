#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  string line;
  int cnt = 0;
  char each_char;
  while(1) {
    getline(cin, line);
    cnt = 0;
    if (line == "#") break;

    for (int i = 0; i < line.length(); i++) {
      each_char = tolower(line[i]);
      if (each_char == 'a' || each_char == 'e' || each_char == 'i' || each_char == 'o' || each_char == 'u') cnt++;
    }
    cout << cnt << '\n';
  }
  return 0;
}