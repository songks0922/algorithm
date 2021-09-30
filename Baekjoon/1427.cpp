#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  string num;
  vector<int> nums;

  cin >> num;

  for (char each_num : num) {
    nums.push_back(each_num - '0');
  }

  sort(nums.begin(), nums.end(), greater<int>());

  for(int i = 0; i < nums.size(); i++) {
    cout << nums[i];
  }
  cout << '\n';
  return 0;
}