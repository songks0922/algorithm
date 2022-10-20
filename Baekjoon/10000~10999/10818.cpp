#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int N;

    cin >> N;
    vector<int> nums;
    int num;
    
    for(int i = 0; i < N; i++) {
      cin >> num;
      nums.push_back(num);
    }

    int max = nums.front();
    int min = max;

    for(int each_num : nums) {
      if (max < each_num) {
        max = each_num;
      }
      if(min > each_num) {
        min = each_num;
      }
    }
    cout << min << ' ' << max <<'\n';
    return 0;
}