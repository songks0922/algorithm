#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int day, car, cnt = 0;
  vector<int> cars;

  cin >> day;
  for (int i = 0; i < 5; i++) {
    cin >> car;
    cars.push_back(car);
  }

  for (int i = 0; i < cars.size(); i++) {
    if (cars[i] == day) cnt++;
  }
  cout << cnt << '\n';
  return 0;
}