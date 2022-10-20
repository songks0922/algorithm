#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n, nums;
  vector<int> histo;

  cin >> n;

  for(int i = 0; i < n; i++) {
    cin >> nums;
    histo.push_back(nums);

  }

  for(int i = 0; i < histo.size(); i++) {
    for (int j = 0; j < histo[i]; j++) {
      cout << '=';
    }
    cout << '\n';
  }
  return 0;
}