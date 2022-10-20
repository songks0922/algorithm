#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int t, c;
  int money[4] = {0, };
  int exchange[4] = {25, 10, 5, 1};

  cin >> t;
  for (int i = 0; i < t; i++) {
    cin >> c;
    for(int j = 0; j < 4; j++) {
      if (c == 0) break;
      money[j] += c / exchange[j];
      c -= money[j] * exchange[j];
    }
    for (int i = 0; i < 4; i++) {
      cout << money[i] << " ";
    }
    cout << '\n';
    for (int i = 0; i < 4; i++) {
      money[i] = 0;
    }
  }

  return 0;
}