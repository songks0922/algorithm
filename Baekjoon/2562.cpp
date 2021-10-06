#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n;
  vector<int> nums;
  for (int i = 0; i < 9; i++) {
    cin >> n;
    nums.push_back(n);
  }

  int maxIndex = max_element(nums.begin(), nums.end()) - nums.begin();
  cout << nums[maxIndex] << '\n' << ++maxIndex << '\n';

  return 0;
}