#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n, vote, dasom, ans = 0;
  vector<int> votes;
  cin >> n >> dasom;

  for (int i = 0; i < n-1; i++) {
    cin >> vote;
    votes.push_back(vote);
  }
  int max_index = max_element(votes.begin(), votes.end()) - votes.begin();

  if(n == 1) {
    cout << "0" << '\n';
    return 0;
  }

  while (!(dasom > votes[max_index])) {
    // sort(votes.begin(), votes.end(), greater<int>());
    max_index = max_element(votes.begin(), votes.end()) - votes.begin();
    votes[max_index]--;
    ans++;
    dasom++;
    max_index = max_element(votes.begin(), votes.end()) - votes.begin();
  }
  cout << ans << '\n';
  return 0;
}