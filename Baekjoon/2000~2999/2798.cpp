#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n, card, sum = 0;
  static int m;
  vector<int> cards;
  vector<int> sums;
  
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> card;
    cards.push_back(card);
  }

  for (int i = 0; i < n; i++) {
    for (int j = i+1; j < n; j++) {
      for (int k = j+1; k < n; k++) {
        sum = cards[i] + cards[j] + cards[k];
        sums.push_back(sum);
      }
    }
  }

  // auto it = remove_if(sums.begin(), sums.end(), [](int num) { return num > m;});
  // sums.resize(it - sums.begin());

  sums.erase(remove_if(sums.begin(), sums.end(), [](int num) { return num > m;}), sums.end());

  int max = *max_element(sums.begin(), sums.end());
  cout << max << '\n';

  return 0;
}