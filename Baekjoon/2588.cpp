#include <iostream>
#include <string>
using namespace std;

int main() {
  int num1, num2;

  cin >> num1 >> num2;
  string temp = to_string(num2);
  cout << num1 * (temp[2] - '0') << endl;
  cout << num1 * (temp[1] - '0') << endl;
  cout << num1 * (temp[0] - '0') << endl;
  cout << num1 * num2 << endl;
  return 0;
}