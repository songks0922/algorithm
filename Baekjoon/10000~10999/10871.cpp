#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int N, X, num;
  vector<int> nums;
  vector<int>::iterator ptr;
  cin >> N >> X;

  for(int i = 0; i < N; i++) {
    cin >> num;
    nums.push_back(num);
  }

  for(ptr = nums.begin(); ptr != nums.end(); ++ptr) {
    if(*ptr < X) {
      cout << *ptr << " ";
    }
  }

  return 0;
}