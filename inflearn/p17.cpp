#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int N, card, answer;

  cin >> N;

  for (int i = 0; i < N; i++) {
    cin >> card >> answer;

    if (answer == (card * (card + 1) / 2)) cout << "YES\n";
    else cout << "NO\n";
  }
  return 0;
}