#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    int score;
    int sum1 = 0, sum2 = 0;

    for (int i = 0; i < 8; i++){
      cin >> score;
      if (i < 4) {
        sum1 += score;
      } else {
        sum2 += score;
      }
    }
    cout << (sum1 > sum2 ? sum1 : sum2) << '\n';

    return 0;
}