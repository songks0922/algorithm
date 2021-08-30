#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    vector<int> scores;
    int score, sum = 0;
    for (int i = 0; i < 6; i++) {
      cin >> score;
      scores.push_back(score);
      if(i == 3) {
        sort(scores.begin(), scores.end());
        for (int i = 0; i < 3; i++)
        {
          sum += scores.back();
          scores.pop_back();
        }
        scores.clear();
      }
    }

    sort(scores.begin(), scores.end());
    sum += scores.back();
    cout << sum << '\n';
    return 0;
}