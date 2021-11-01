#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n;
  float score, sum = 0;
  vector<float> scores;

  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> score;
    scores.push_back(score);
  }
  int maxScore = *max_element(scores.begin(), scores.end());

  for (int i = 0; i < n; i++) {
    sum += (scores[i] / maxScore) * 100;
  }

  cout << (sum / n) << '\n';
  return 0;
}