#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n, fruit, snakeLen;
  vector<int> fruits;

  cin >> n >> snakeLen;
  for (int i = 0; i < n; i++) {
    cin >> fruit;
    fruits.push_back(fruit);
  }
  
  sort(fruits.begin(), fruits.end());
  vector<int>::iterator iter;

  for (iter = fruits.begin(); iter != fruits.end(); iter++) {
    if (*iter <= snakeLen) snakeLen++;
    else break;
  }

  cout << snakeLen << '\n';

  return 0;
}