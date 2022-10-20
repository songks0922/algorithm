#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(pair<int, int> p1, pair<int, int> p2) {
  return p1.second > p2.second;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  vector<pair<int, int>> v;
  vector<int> nums;
  int score, sum = 0;

  for (int i = 1; i < 9; i++) {
    cin >> score;
    pair<int, int> p = make_pair(i, score);
    v.push_back(p);
  }

  sort(v.begin(), v.end(), cmp);

  for (int i = 0; i < 5; i++) {
    sum += v[i].second;
    nums.push_back(v[i].first);
  }
  cout << sum << '\n';

  sort(nums.begin(), nums.end());

  for (int i = 0; i < 5; i++) {
    cout << nums[i] << ' ';
  }
  cout << '\n';
  return 0;
}