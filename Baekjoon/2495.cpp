#include <iostream>
#include <string>

using namespace std;


int main(void)
{
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  string s;
  string line;
  for (int i = 0; i < 3; i++) {
    getline(cin, line);
    int max = 0, curr = 0;
    
    for (int j = 0; j < line.length() - 1; j++) {
      if(line[j] == line[j+1]) {
        curr++;
      } else{
        max = max > curr ? max : curr;
        curr = 0;
      }
    }
    max = curr == 7 ? curr : max;
    max = max > curr ? max : curr;
    cout << ++max << '\n';

  }

  return 0;
}