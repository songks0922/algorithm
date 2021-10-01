#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int t, num;
  vector<int> nums;

  cin >> t;
  for (int i = 0; i < t; i++) {
    for (int j = 0; j < 10; j++) {
      cin >> num;
      nums.push_back(num);
    }
    sort(nums.begin(), nums.end(), greater<int>());
    cout << nums[2] << '\n';
    nums.clear();
  }
  return 0;
}