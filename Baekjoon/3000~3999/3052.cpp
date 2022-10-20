#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  const int TODIVDE = 42;
  int n;
  vector<int> remainders;
  
  for (int i = 0; i < 10; i++) {
    cin >> n;
    int remainder = n % TODIVDE;
    if (find(remainders.begin(), remainders.end(), remainder) == remainders.end()) {
      remainders.push_back(remainder);
    }
  }

  cout << remainders.size() << '\n';
  return 0;
}