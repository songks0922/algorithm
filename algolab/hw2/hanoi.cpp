#include <iostream>
using namespace std;

void hanoi(int n, int a, int b, int c);
int stack[11];
int k = 0;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int t, n;
  cin >> t;

  for (int i = 0; i < t; i++) {
    cin >> n;
    hanoi(n, 1, 2, 3);
    cout << '\n';
    k = 0;
  }

  
  return 0;
}

void hanoi(int n, int a, int b, int c) {
  if (n > 0) {
    hanoi(n - 1, a, c, b);
    if (c == 3) {
      stack[++k] = n;
      cout << stack[k] << ' ';
    } else if (a == 3) {
      cout << stack[--k] << ' ';
    }
    hanoi(n - 1, b, a, c);
  }
}