#include <iostream>
using namespace std;

void swap(int &n1, int &n2) {
  int temp = n2;
  n2 = n1;
  n1 = temp;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int num[3];

  for (int i = 0; i < 3; i++) {
    cin >> num[i];
  }

  for (int i = 0; i < 3; i++) {
    for (int j = i+1; j < 3; j++) {
      if(num[i] > num[j]) {
        swap(num[i], num[j]);
      }
    }
  }

  for (int i = 0; i < 3; i++) {
    cout << num[i] << ' ';
  }
  return 0;
}