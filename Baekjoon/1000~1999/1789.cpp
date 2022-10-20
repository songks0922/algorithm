#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  long n, sum = 0;
  int nums = 0;
  cin >> n;

  while(n >= sum) {
    sum += ++nums;
  }
  cout << (sum == nums ? nums : --nums);
  return 0;
}