#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  vector<long long> answer;
  int x, n;
  
  cin >> x >> n;
  for(int i = 1; i <= n; i++) {
    answer.push_back(x * i);
  }
  
  return 0;
}