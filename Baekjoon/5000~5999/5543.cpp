#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  vector<int> buggers;
  vector<int> drinks;

  int food;
  for (int i = 0; i < 5; i++) {
    cin >> food;
    if (i < 3) {
      buggers.push_back(food);
    } else {
      drinks.push_back(food);
    }
  }

  sort(buggers.begin(), buggers.end());
  sort(drinks.begin(), drinks.end());

  cout << buggers.front() + drinks.front() - 50 << '\n';
  return 0;
}