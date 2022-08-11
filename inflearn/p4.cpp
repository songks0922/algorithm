#include <iostream>
#include <limits>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  //freopen("input.txt", "rt", stdin);
  int n, age;
  int max = numeric_limits<int>::min();
  int min = numeric_limits<int>::max();

  cin >> n;
  
  for (int i = 1; i <= n; i++) {
    cin >> age;
    if (age < min) min = age;
    if (age > max) max = age;
  }

  cout << max - min << endl;
  return 0;
}