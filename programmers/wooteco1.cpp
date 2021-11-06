#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int money;
  int result[9] = {0, };
  int moneyList[9] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

  cin >> money;
  for (int i = 0; i < 9; i++) {
    result[i] += money / moneyList[i];
    money %= moneyList[i];
    if (money == 0) break;
  }
  cout << '[';
  for(int i = 0; i < 9; i++) {
    cout << result[i] << (i == 8 ? "" : ", ");
  }
  cout << ']';
  
  return 0;
}