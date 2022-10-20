#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int T;

  cin >> T;

  while (T--) {
    int N, M;

    cin >> N >> M;

    long long answer = 1;

    int edge = 1;

    for (int i = M; i > M - N; i--) {
      answer *= i;
      answer /= edge++;
    }

    cout << answer << '\n';
  }

  return 0;
}