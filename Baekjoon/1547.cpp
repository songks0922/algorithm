#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int M, cup1, cup2, temp, position = -1;
  int cups[3] = {1, 0, 0};
  
  cin >> M;
  for (int i = 0; i < M; i++) {
    cin >> cup1 >> cup2;
    if(cup1 == cup2) continue;
    temp = cups[cup1-1];
    cups[cup1-1] = cups[cup2-1];
    cups[cup2-1] = temp;
  }

  for (int i = 0; i < 3; i++) {
    if (cups[i] == 1) {
      position = i + 1;
    }
  }

  cout << position << '\n';
  
  return 0;
}