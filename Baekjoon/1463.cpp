// 1로 만들기
#include <iostream>
using namespace std;

int min(int a, int b) {
  return a > b ? b : a;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int arr[1000001] = {0, };
  int N;
  arr[1] = 0; //base case!!!
  cin >> N;
  for (int i = 2; i <= N; i++) {
    arr[i] = arr[i-1] + 1;
    if (i % 2 == 0) {
      arr[i] = min(arr[i], arr[i/2] + 1);
    }
    if (i % 3 == 0) {
      arr[i] = min(arr[i], arr[i/3] + 1);
    }
  }

  cout << arr[N] << '\n';

  return 0;
}