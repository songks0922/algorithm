#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n, score, myScore, p, rank = 1;
  vector<int> scores;

  cin >> n >> myScore >> p;

  for (int i = 0; i < n; i++) {
    cin >> score;
    scores.push_back(score);
  }

  sort(scores.begin(), scores.end(), greater<int>());

  if (n == p && scores[n-1] >= myScore) {
    rank = -1;
  } else {
    for (int i = 0; i < n; i++) {
      if (scores[i] > myScore) {
        rank++;
      }
    }
  }
  cout << rank << '\n';
  return 0;
}